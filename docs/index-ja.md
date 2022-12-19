# Visual Inspection : Webサイトの画面確認を自動化しよう

## はじめに

わたしはWebアプリケーションのUIをテストとする作業をソフトウェアで自動化する技術に関心があります。わたしは2018年9月に下記の記事をQiitaに投稿しました。

-   [Katalon StudioでVisual Testingを実現した](https://qiita.com/kazurayam/items/bcf72a03f50fc5db4373)

このとき実装したコードにいろいろ不満があった。わたしは開発を続けました。ようやく実用レベルのツールを仕上げることができたのでここで紹介します。このツールを *Visual Inspection* と称します。

## Visual Inspectionが出力するレポートのサンプル

Visual Inspectionを実行するとどういう出力が得られるのか？サンプルがあります。下記リンクをクリックして眺めてください。

-   [store/index](https://kazurayam.github.io/inspectus4katalon-sample-project/demo/store/index.html)

このサンプルをブラウザで開いてあちこちページをめくって眺める様子を動画にしてみました。

&lt;iframe width="560" height="315" src="https://www.youtube.com/embed/pxZRS5-rigM" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen&gt;&lt;/iframe&gt;

このレポートの見方をざっと説明しましょう。

### 二つの画像の差分

あるWebページのスクリーンショットを撮り、数秒後にもう一度スクリーンショットを撮った。二つの画像をピクセル単位で比較した結果の画像を生成した。食い違っている箇所のピクセルを赤色に塗ることで相違点を見やすくした。

![Left Diff Right](https://kazurayam.github.io/inspectus4katalon-sample-project/images/Left-Diff-Right.png)

サンプルとして使ったWebページ <http://demoaut-mimic.kazurayam.com/> には秒単位の時刻が表示される。間隔をおいて問い合わせれば秒の箇所が変化するので、差分画像の中にわずかながら赤い塗りつぶしが必ず生じる。

あなたのWebサイトをVisual Inspectionしたら、どのページのどの箇所が赤くなるだろうか？ --- それはやってみなければわかりません。ぜひ自分で試してみてください。

### 二つのテキストの差分

### diff ratio, FileType, Metadata

二つのファイルと差分ファイルをまとめた組のことを [MaterialProduct](https://github.com/kazurayam/materialstore/blob/main/src/main/java/com/kazurayam/materialstore/base/reduce/zipper/MaterialProduct.java) というclassで表します。レポートの中に下記のような表示がありますが、これは Material Product の属性情報です。

![diffratio fileType metadata](https://kazurayam.github.io/inspectus4katalon-sample-project/images/diffratio-fileType-metadata.png)

左上の `0.14%` という数字を **diff ratio** と呼びます。画面の四角形全体の大きさを100.00%として、赤く塗られた差分箇所が何パーセントを占めているかを表しています。"0.14%"という例は "完全に同じではない、ちょっとだけ違っている" と読める。diff ratioがが 96.0% とか大きな値になることもあり得ます。きっと何かエラーが発生した印でしょう。

diff ratioの次にある `png` というのは、[FileType](https://github.com/kazurayam/materialstore/blob/main/src/main/java/com/kazurayam/materialstore/core/filesystem/FileType.java) つまりファイルの種類を表す記号です。`png` はPNG画像ファイルを表し、`html` はHTMLテキストファイルを表します。

FileTypeの次に少し長い文字列が続きます。

    {"step:"01", "profile":"ProductionEnv", "URL.host":"demoaut-mimic.kazurayam.com", "URL.path":"/", "URL.port":"80", "URL.protocol":"http"}

この文字列を [Metadata](https://github.com/kazurayam/materialstore/blob/main/src/main/java/com/kazurayam/materialstore/core/filesystem/QueryOnMetadata.java) メタデータと呼びます。２つのスクリーショット画像と差分画像の組について付加された説明です。

Visual Inspectionのソフトウェアは特殊なファイルシステムを装備しています。そのファイルシステムをわたしは [materialstore](https://github.com/kazurayam/materialstore/tree/main/src/main/java/com/kazurayam/materialstore/core/filesystem) と呼んでいます。`materialstore` を使えばWeb画面のスクリーンショットやHTMLソースに対してURLをはじめとする任意のメタデータを付与してローカルディスクに保存することができます。そしてメタデータをキーとして検索してファイルを取り出すことができます。materialstore はVisual Inspectionを実装するために設計された問題特化型データベースですです。

### Chronos Diff

Visual InspectionはひとつのWebサイトのスクリーンショットを２回撮って前後の画面を見比べることができます。<http://demoaut-mimic.kazurayam.com/> というテスト用のURLを標的に前後比較をしたとき出力されたレポートが下記のものです。このURLの画面の中には現在時刻が表示されている（例えば `2022/12/19 1:5:8 UTC`）ので、スクリーンショットを2度に分けて撮れば微小ながら必ず差異が生じます。レポートが画像の差異をレポートしてくれていることを見てください。

-   [CURA 1回目](https://kazurayam.github.io/inspectus4katalon-sample-project/demo/store/CURA-20221213_080716.html)

-   [CURA 2回目](https://kazurayam.github.io/inspectus4katalon-sample-project/demo/store/CURA-20221213_080831.html)

次の図はこのレポートがどのような内部処理によって作成されたかを示しています。

![activity cura](https://kazurayam.github.io/inspectus4katalon-sample-project/diagrams/out/activity-chronosdiff-ja/activity-chronosdiff-ja.png)

image:https://kazurayam.github.io/inspectus4katalon-sample-project/diagrams/out/chronos

### Twins Diff: Webサイトの本番環境と開発環境を比較する

-   \[MyAdmin\](<https://kazurayam.github.io/inspectus4katalon-sample-project/demo/store/MyAdmin-20221213_080556.html>)

前述したChronos DiffはひとつのWebサイトを違うタイミングで2回スナップショットしましたが、Twins Diffは違います。Twins Diffを実行する際にはwebサイトの本番環境と開発環境のようにURLの中のホスト名部分が違う２つのURLを与えます。例えば

-   `http://myadmin.kazurayam.com/` (本番環境)

-   `http://devadmin.kazurayam.com/` (開発環境)

のように。そしてサイトを構成するページのURLのパス部分を列挙したCSVファイルを与えます。例えば

    include:../Include/data/MyAdmin/targetList.csv

のように。

Twins Diffは指定されたURLのホスト名とCSVファイルから読み取ったパス文字列を合成してURLを特定します。そしてそのURLをブラウザで開いてスクリーンショットを撮ります。URLのパス文字列が一致する画像どおしを比較して差分を求めレポートを作成します。

[activity twins](https://kazurayam.github.io/inspectus4katalon-sample-project/diagrams/out/activity-twinsdiff-ja/activity-twinsdiff-ja.png!)

### Shootings

画像を比較して差分を求めるような高度な加工をせず、ただスクリーンショットを撮って、それを一覧表示したいだけ、という場合もありましょう。そのとき役立つツールもあります。

-   [DuckDuckGo](https://kazurayam.github.io/inspectus4katalon-sample-project/demo/store/DuckDuckGo-20221213_080436.html)

検索サービス [DuckDuckGo](https://duckduckgo.com/) をブラウザで開き、キーワードとして "selenium" を指定して、関連するサイトの一覧を求める。web画面のスクリーンショットを取得してPNG画像としてローカルディスクに保存し、ついでにweb画面のHTMLソースコードも保存する。各画面のURLなどのメタ情報も記録する。ファイルの一覧を表示するHTMLを生成しました。

## Visual Inspectionを動かしてみよう

### 環境を設定する

#### Katalon Studio - Standalone Editionをインストールする。

下記URLからKatalon Studioのバイナリをダウンロードすることができます。

-   <https://katalon.com/download>

Standalone Editionは無償利用が可能ですから、わたしはStandalone Editionをお勧めします。

ダウンロードしたバイナリからKatalon Studioをどのフォルダにインストールするかに少し注意が必要です。あなたのWindowsログインユーザがREAD/WRITE権限をフルに持っているフォルダならどこでもOKです。たとえば `C:\Users\youName\Documents` フォルダの下とか。`C:\Program Files` の下にインストールすると場合によってはWRITE権限が不足なためエラーが起きる場合があります。

#### プロジェクトを作る

Standalone Edition

## 雑談

### Visual Inspection とは何か

*Visual Inspection* は人間がWebサイトの画面をブラウザで開いてたくさんのページを眺めて **どこかおかしなところはないか?** と目視で確認する、その作業をツールで自動化することを目的とするツールです。よく似た別の言葉 "Visual Testing" をキーワードにGoogle検索すると商用ソフトウェア製品やサービスがいくつも見つかります。例えば

-   [browserstack](https://www.browserstack.com/guide/visual-testing-beginners-guide)

-   [applitool](https://applitools.com/learn/concepts/visual-testing/)

-   [katalon’s Visual Testing](https://katalon.com/visual-testing)

しかし Visual Inspection をGoogle検索しても何も出てきません。無理もない。わたしが「画面確認の自動化」をアルファベットで表記するために作った造語だから。

*Testing* とはあらかじめ条件を特定しておき対象となるソフトウェアが期待通りに動作するかどうかを確認することと定義しましょう。いっぽう *Inspection 検査* とはWebシステムが提供する画面をできるだけたくさん眺める。そして「おや、これは何だ？」と不審な箇所を発見することを目指します。InspectionはTestingとは違う目的を持っています。

### Visual Inspectionは誰のためのツールか

[Qiita](https://qiita.com/)の読者の大半は現役プログラマであり、ソフトウエアの開発を本職としている人たちでしょう。Visual Inspectionは彼らプロのためのツールではありません。IT系じゃない一般企業に就職した新人君が、上司から

&gt;「ウチのこのWebサイトにおかしなところが無いかどうか、全部のページを目で見て確認してくれ。」

といわれた。そういう新人君は毎年何千人もいるだろう。Visual Inspectionはこうした新人君の作業を楽にするためのツールです。

新人君はまだプログラミングの訓練を受けていない、Webサイトを実現しているIT技術のこと（ReactとかSpringとか…​）はわからない。新人君が配属された部署は、SIerが開発して納品したソフトウェアを受け取って、できるかぎり動作確認して、稼働環境に投入して、自社のWebサービスを継続的に運転していく責任がある。本番としてリリースした画面に問題があってサイト利用者から指摘されたら、さあ大変。新人君はそうならないように画面確認作業を繰り返す。しかし画面確認は正直いって面倒くさいし面白くない。せめて注目すべき箇所を見つけ出すぐらいのことは自動化したい。・・・Visual Inspectionはこの新人君のためのツールです。

### Visual Inspectionと商用製品・サービスとの違い

#### 自社のデータを社外に出すことの是非

Katalon Studioにも [Visual Testing](https://katalon.com/visual-testing) のサービスが組み込まれています。このサービスはテストが生成したファイルをインターネット経由でKatalon社のサービスへ出力しサーバサイドで画像比較とレポート出力をするという形を取ります。わたしが各社のwebサイトの説明を読んだかぎりApplitoolsをはじめとするVisual Testingサービスは皆同じでした。ユーザーが所属する企業が社内情報が漏洩するリスクを嫌って自社データを社外に出力することを禁止している場合、商用のVisual Testingサービスを導入するのは無理です。

いっぽうわたしの開発したVisual Inspecton for Katalon StudioはあなたのPCの上で完結します。結果として生成したファイルをローカルディスクに出力するにとどまります。テストが生成したファイルをインターネット経由で他社が管理するクラウドストレージに出力することを必須としません。だから企業の情報セキュリティの壁を崩す心配がありません。

#### データ転送にかかる時間

一つのwebサイトを画面確認しようとして200画面分スクリーンショットを撮ったとします。Visual Inspection for Katalon StudioはPNGファイルをローカルディスクに保存して処理するので、さほど時間はかかりません。いっぽう商用サービスは多数の画像ファイルをPCからリモートのサーバーへネットワーク経由で転送します。あたなが使えるネットワークの速度に依存しますが、画像ファイルを転送するためだけに何分も時間がかかるであろうことは予想できます。

#### Chronos DiffはよそにもあるがTwins Diffはここだけ

わたしのツールはChronos DiffとTwins Diffの2通りの比較方式をサポートしています。

Chronos Diffとは、一つのURLについて時間間隔をおいて二度スナップショットを撮ったものを比較します。あなたのwebシステムの本番環境のスナップショットを午後１５時に取得し、入替等の作業をしてから、午後１６時にもう一度同じ環境のスナップショットをとる、そして作業の前後を比較して不慮のミスを犯していないかどうかを確認するような使い方ができます。

![activity ChronosDiff](https://kazurayam.github.io/inspectus4katalon-sample-project/diagrams/out/activity-chronosdiff-ja/activity-chronosdiff-ja.png)

いっぽうTwins Diffとはあなたのwebシステムが2つの環境を持っていてトップページのURLのホスト名だけが違っているとして、2つの環境のスナップショットをほぼ同じタイミングで取得し、二つのスナップショット画像をうまく突き合わせて比較する、という目的に向いています。例えば 本番環境 `myadmin.kazurayam.com` と 開発環境 `devadmin.kazurayam.com` を比較することができます。元となるURLのホスト名が同一ではないスナップショットを\*うまく突き合わせ\*て組にするためのルールを組み立てる必要があって、ちょっと複雑にならざるを得ないのですが、わたしのツールはサポートしています。

![activity TwinsDiff](https://kazurayam.github.io/inspectus4katalon-sample-project/diagrams/out/activity-twinsdiff-ja/activity-twinsdiff-ja.png)()

世の中のVisual Testing製品が実現しているのは、わたしのツールがChronos Diffと呼んでいるものだけです。**Twins Diffを実現している製品はわたしの見るところ他にありません。**

### オープンソース、無償利用可能であること

Visual Inspectionはわたしが開発したオープンソースのソフトウェアライブラリ2つによって実装されています。

1.  [kazurayam/materialstore](https://github.com/kazurayam/materialstore)

2.  [kazurayam/inspectus](https://github.com/kazurayam/inspectus)

これらはApache2ライセンスを適用しており無償で利用可能です。従ってVisual Inspectionもオープンソースであり無償で利用可能です。

### Katalon Studioが必須ではない

今回紹介したデモは [Katalon Studio](https://katalon.com/download)を使って、Katalon Studioのプロジェクトとして作成しました。しかし上記に示したライブラリ(materialstoreとinspectus)はKatalon StudioのAPIにまったく依存していません。だからKatalon Studio無しでVisual Inspectionのプロジェクトを構成することができます。Java8 + Gradle + Selenium WebDriver で構成したVisual Inspectionプロジェクトの例が下記にあります。

1.  <https://github.com/kazurayam/inspectus4selenium-sample-project>

こちらのプロジェクトを説明するのはまた別の機会に。
