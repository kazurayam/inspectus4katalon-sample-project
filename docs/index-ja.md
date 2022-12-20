-   <a href="#visual-inspection-webサイトの画面確認を自動化しよう" id="toc-visual-inspection-webサイトの画面確認を自動化しよう">Visual Inspection : Webサイトの画面確認を自動化しよう</a>
    -   <a href="#はじめに" id="toc-はじめに">はじめに</a>
    -   <a href="#visual-inspectionが出力するレポートのサンプル" id="toc-visual-inspectionが出力するレポートのサンプル">Visual Inspectionが出力するレポートのサンプル</a>
    -   <a href="#サンプルの説明" id="toc-サンプルの説明">サンプルの説明</a>
        -   <a href="#二つの画像の差分" id="toc-二つの画像の差分">二つの画像の差分</a>
        -   <a href="#二つのテキストの差分" id="toc-二つのテキストの差分">二つのテキストの差分</a>
        -   <a href="#スクリーンショットの一覧" id="toc-スクリーンショットの一覧">スクリーンショットの一覧</a>
    -   <a href="#visual-inspectionのサンプルプロジェクトを動かしてみる" id="toc-visual-inspectionのサンプルプロジェクトを動かしてみる">Visual Inspectionのサンプル・プロジェクトを動かしてみる</a>
        -   <a href="#katalon-studioを準備する" id="toc-katalon-studioを準備する">Katalon Studioを準備する</a>
            -   <a href="#katalon-studioをインストールする" id="toc-katalon-studioをインストールする">Katalon Studioをインストールする</a>
            -   <a href="#katalon-studioのguiを起動してユーザー登録をする" id="toc-katalon-studioのguiを起動してユーザー登録をする">Katalon StudioのGUIを起動してユーザー登録をする</a>
            -   <a href="#katalon-studioを設定する" id="toc-katalon-studioを設定する">Katalon Studioを設定する</a>
            -   <a href="#初めてのプロジェクトを作りプロジェクトを設定する" id="toc-初めてのプロジェクトを作りプロジェクトを設定する">初めてのプロジェクトを作り、プロジェクトを設定する</a>
            -   <a href="#初めてのtest-caseを作って動かしてみる" id="toc-初めてのtest-caseを作って動かしてみる">初めてのTest Caseを作って動かしてみる</a>
        -   <a href="#サンプルプロジェクトを準備する" id="toc-サンプルプロジェクトを準備する">サンプル・プロジェクトを準備する</a>
        -   <a href="#git-for-windowsをインストールする" id="toc-git-for-windowsをインストールする">Git for Windowsをインストールする</a>

# Visual Inspection : Webサイトの画面確認を自動化しよう

## はじめに

わたしはWebアプリケーションのUIをテストとする作業をソフトウェアで自動化する技術に関心があります。わたしは2018年9月に下記の記事をQiitaに投稿しました。

-   [Katalon StudioでVisual Testingを実現した](https://qiita.com/kazurayam/items/bcf72a03f50fc5db4373)

このとき実装したプロジェクトは [Katalon Studio](https://duckduckgo.com/?q=Katalon+Studio&atb=v314-1&ia=web)をベースにGroovy言語でスクリプトを書いて作った。この時の成果物にわたしは満足していませんでした。わたしは開発を続けて、ようやく使い物になるツールに仕立てることができた。このツールを *Visual Inspection* と名付けました。ここでVisual Inspectionを紹介します。

## Visual Inspectionが出力するレポートのサンプル

Visual Inspectionを実行するとどういう出力が得られるのか？サンプルがあります。下記リンクをクリックして眺めてください。

-   [store/index](https://kazurayam.github.io/inspectus4katalon-sample-project/demo/store/index.html)

このサンプルをブラウザで開きあちこち眺める様子を動画にしてみました。

&lt;iframe width="560" height="315" src="https://www.youtube.com/embed/pxZRS5-rigM" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen&gt;&lt;/iframe&gt;

## サンプルの説明

このレポートの見方をざっと説明しましょう。

### 二つの画像の差分

ひとつ目のサンプルの、あるWebページのスクリーンショットを撮り、数秒後にもう一度スクリーンショットを撮って、二つの画像を比較するという検査の結果です。違っているピクセルが赤色に塗られる。標的にしたWebページ <http://demoaut-mimic.kazurayam.com/> には秒単位の現在時刻が表示されるのですが、１回目と２回目の間に適当な時間差をおけば時刻が変わるから、差分画像の中に赤い塗りつぶしがわずかながら生じます。こんなふうに：

![Left Diff Right](https://kazurayam.github.io/inspectus4katalon-sample-project/images/Left-Diff-Right.png)

あなたのWebサイトを標的としてVisual Inspectionを実施したら、どのページのどの箇所が赤くなるだろうか？ --- ぜひ自分で試してみてください。

### 二つのテキストの差分

標的にしたWebページ <http://demoaut-mimic.kazurayam.com/> のDiffに赤い塗り潰しを見つけて「おや？どうしてこうなったんだ」と気づいたら、あなたは次に、WebページのHTMLソースコードのどこがどのように違っているのか、確かめたくなるでしょう。その疑問に即答するために、WebページのHTMLソースをブラウザから取り出して記録として保存しています。下記の画像は二つのHTMLのdiffを表示している例です。

![HTMLsource diff](https://kazurayam.github.io/inspectus4katalon-sample-project/images/HTMLsource_diff.png)

HTMLソースコードだけでなく他のさまざまな形式のテキストを差分検査の対象とすることができます。JSON、XML、CSVといったデータ記述向きのテキストはもちろん、`.js` や `.css` のようなプログラム・コードも差分検査することができます。

### スクリーンショットの一覧

自分が運営するwebサイトのスクリーンショットをたくさん撮って一覧を作りたい、差分検査はとりあえず要らない。そういうシンプルな要求を満たすための機能もサポートしています。次のデモを見てください。検索サイト [DuckDuckGo](https://duckduckgo.com/?) をブラウザで開いて、キーワード `selenium` を指定してENTERし検索結果を見る。その過程で画面のスクリーンショットとHTMLソースを取得し保存する。最後に一覧をHTMLとして生成する。これだけのことをしたデモです。

-   [DuckDuckGoのスクリーンショット一覧のデモ](https://kazurayam.github.io/inspectus4katalon-sample-project/demo/store/DuckDuckGo-20221213_080436.html)

![DuckDuckGo small](images/DuckDuckGo_small.png)

## Visual Inspectionのサンプル・プロジェクトを動かしてみる

前に紹介したサンプルを出力するプロジェクトをあなたのPCで動かしてみましょう。環境を準備することから始めましょう。あなたが Windows10 のPCを持っていてインターネットに接続可能であると前提します。ツール類を未だインストールしていないと前提して一から説明します。

### Katalon Studioを準備する

#### Katalon Studioをインストールする

"Katalon Studio - Standalone Edition"の配布用zipファイルを下記URLからダウンロードすることができます。Standalone Editionは無償で利用できます。わたしの環境ではダウンロードに７分ほどかかりました。

-   <https://katalon.com/download>

![Katalon Download page](https://kazurayam.github.io/inspectus4katalon-sample-project/images/Katalon-Studio-Free-Download-Katalon.png)

"Katalon Studio - Platform Edition" はGUIつきフル機能搭載の製品で有償です。"Katalon Runtime Engine" はCI/CD環境用でコマンドラインでGUI無しに実行するためのバイナリで有償です。これら三種類の製品どれでも Visual Inspection を動かすことができますが、Visual Inspectionのために有償版は必要ありません。

DOWNLOADボタンを押すと "Create a Katalon account" つまりKatalonユーザとしてあなた個人用のアカウントを登録しろと案内されます。

![Sign up Katalon Software Quality Management Platform](https://kazurayam.github.io/inspectus4katalon-sample-project/images/Sign-up-Katalon-Software-Quality-Management-Platform.png)

無償版を使う場合には Full name と Email と Password に適当な文字を入力すればOK。後で必要になるのでメモしておきましょう。別のデータベースと照合して認証するような手の込んだことはしていないようです。有償版を使う場合にはEmailアドレスについて一定の条件を満たすよう求められますがここでは述べません。

Standalone EditionのzipファイルをPCにダウンロードしたらダブルクリックして `Katalon_Studio_Windows_64-x.x.x` フォルダを展開しましょう。どこに配置するかに注意が必要です。あなたのWindowsユーザがフルにWRITE権限を持っているフォルダの下に配置することが必要です。たとえば `C:\Users\あなたのWindowsユーザ名\Katalon_Studio_Windows_64-x.x.x` フォルダを作るのが良いでしょう。しかし `C:\Program Files` フォルダの下に置くとWRITE権限が足りなくてエラーが発生するかもしれない。避けるべきです。`C:\Users\あなたのWindowsユーザ名\Documents` フォルダはひょっとしたら OneDrive と連携して自動バックアップをとる構成になっているかもしれなくて、そこに大きなバイナリを置くのは避けたほうがいいでしょう。

#### Katalon StudioのGUIを起動してユーザー登録をする

展開したフォルダの中に `katalon.exe` がある。これをダブルクリックしてKatalon StudioのGUIを起動します。

![katalon.exe](https://kazurayam.github.io/inspectus4katalon-sample-project/images/katalonexe.png)

初めて起動したとき「SmartScanが」どうこうとか、「Defenderファイアウオールでブロックされています」とかセキュリティに絡む忠告をされるかもしれないが、あまり気にせず許可してしまいましょう。

Katalon Studioを起動した時、一度だけ、先ほど登録したKatalonユーザとしてのFull nameとEmailとPasswordの入力を求められます。先ほどメモした文字をタイプすればそれでおしまい。有償版だと自社が購入したライセンスの上限の範囲内にユーザ数が収まっているかどうかのチェックがこの段階で作動します。

#### Katalon Studioを設定する

1.  Proxyを設定する（必要ならば）

2.  WebDriverをアップデートする

3.  Scripモードを使う、Manualモードを使わない

#### 初めてのプロジェクトを作り、プロジェクトを設定する

1.  ブラウザの種類を選ぶ

2.  Log Viewerを設定する

3.  TestOpsをintegrateしない

4.  TestCloudをintegrateしない

5.  Smart Waitを使わない

#### 初めてのTest Caseを作って動かしてみる

`openBrowser_navigateToUrl_closeBrowser`

これでひとまずKatalon Studioの設定が出来ました。

### サンプル・プロジェクトを準備する

Visual Inspectionを実装したKatalon Studioプロジェクトのサンプルが下記のGitHubレポジトリにあります。

-   <https://github.com/kazurayam/inspectus4katalon-sample-project>

[Qiita](https//qiita.com/)の読者ならこのGitHubプロジェクトをgit cloneしてWindows PCで動かすことなど説明されるまでもなくできるでしょう。それでもいいのですが、ここではgitコマンドを使わないで、別の方法を紹介します。ビルドツール [Gradle](https://gradle.org/) を使います。ただしそのやり方を実行するにはいくつか追加の準備が必要です。少し長いですが、やっていきましょう。

### Git for Windowsをインストールする

-   [Git for Windows](https://gitforwindows.org/)

このサイトのdownloadボタンを押します。インストーラーがダウンロードできます。インストーラーを実行してください。すべてデフォルトの設定を選択するのでいい。インストールが完了すると `Git Bash` が使えるようになります。Git Bashを開いてください。

===

`MyVisualInspectionProject` フォルダの直下に `build.gradle` ファイルがある（はずです）。build.gradleを下記のように書き換えます。

    plugins {
      id 'com.kazurayam.inspectus4katalon' version "0.3.4"
    }

そしてKatalon Studioを一旦止めます。そしてコマンドラインで下記のようにコマンドを２つ、実行します。

    $ cd MyVisualInspectionProject
    $ gradle drivers
    ...
    $ gradle deploy-visual-inspection-sample-for-katalon
    ...

このコマンドにより必要なサンプルコードが一揃いインターネット上のレポジトリからダウンロードされる。

Katalon Studioを再び起動してMayVisualInspectionプロジェクトを開くと、プロジェクトの中に新しいフォルダができて、中にスクリプトが入っている　。。。
