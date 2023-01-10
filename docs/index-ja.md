-   <a href="#visual-inspection-webサイトの画面確認を自動化しよう" id="toc-visual-inspection-webサイトの画面確認を自動化しよう">Visual Inspection : Webサイトの画面確認を自動化しよう</a>
    -   <a href="#はじめに" id="toc-はじめに">はじめに</a>
    -   <a href="#visual-inspectionが出力するレポートのサンプル" id="toc-visual-inspectionが出力するレポートのサンプル">Visual Inspectionが出力するレポートのサンプル</a>
    -   <a href="#サンプルの説明" id="toc-サンプルの説明">サンプルの説明</a>
        -   <a href="#二つの画像の差分" id="toc-二つの画像の差分">二つの画像の差分</a>
        -   <a href="#二つのテキストの差分" id="toc-二つのテキストの差分">二つのテキストの差分</a>
        -   <a href="#スクリーンショットの一覧" id="toc-スクリーンショットの一覧">スクリーンショットの一覧</a>
    -   <a href="#katalon-studioを準備する" id="toc-katalon-studioを準備する">Katalon Studioを準備する</a>
        -   <a href="#katalon-studioをインストールする" id="toc-katalon-studioをインストールする">Katalon Studioをインストールする</a>
        -   <a href="#katalon-studioのguiを起動してユーザー登録をする" id="toc-katalon-studioのguiを起動してユーザー登録をする">Katalon StudioのGUIを起動してユーザー登録をする</a>
        -   <a href="#katalon-studio全体にわたる設定をする" id="toc-katalon-studio全体にわたる設定をする">Katalon Studio全体にわたる設定をする</a>
            -   <a href="#proxyを設定する" id="toc-proxyを設定する">Proxyを設定する</a>
            -   <a href="#webdriverをアップデートする" id="toc-webdriverをアップデートする">WebDriverをアップデートする</a>
            -   <a href="#scrip-viewを使うmanual-viewを使わない" id="toc-scrip-viewを使うmanual-viewを使わない">Scrip viewを使う、Manual viewを使わない</a>
        -   <a href="#プロジェクトを作る" id="toc-プロジェクトを作る">プロジェクトを作る</a>
        -   <a href="#プロジェクトを設定する" id="toc-プロジェクトを設定する">プロジェクトを設定する</a>
            -   <a href="#ブラウザの種類を選ぶ" id="toc-ブラウザの種類を選ぶ">ブラウザの種類を選ぶ</a>
            -   <a href="#testopsを使わない" id="toc-testopsを使わない">TestOpsを使わない</a>
            -   <a href="#testcloudを使わない" id="toc-testcloudを使わない">TestCloudを使わない</a>
            -   <a href="#smart-waitを使わない" id="toc-smart-waitを使わない">Smart Waitを使わない</a>
            -   <a href="#log-viewerを軽量化する" id="toc-log-viewerを軽量化する">Log Viewerを軽量化する</a>
        -   <a href="#初めてのtest-caseを作って動かしてみる" id="toc-初めてのtest-caseを作って動かしてみる">初めてのTest Caseを作って動かしてみる</a>
    -   <a href="#ビルドツール-gradle-を準備する" id="toc-ビルドツール-gradle-を準備する">ビルドツール Gradle を準備する</a>
        -   <a href="#git-for-windowsをインストールする" id="toc-git-for-windowsをインストールする">Git for Windowsをインストールする</a>
        -   <a href="#sdkmanをインストールする" id="toc-sdkmanをインストールする">SDKMAN!をインストールする</a>
        -   <a href="#javaをインストールする" id="toc-javaをインストールする">Javaをインストールする</a>
        -   <a href="#gradleをインストールする" id="toc-gradleをインストールする">Gradleをインストールする</a>
    -   <a href="#自作のkatalonプロジェクトにvisual-inspectionを組み込む" id="toc-自作のkatalonプロジェクトにvisual-inspectionを組み込む">自作のKatalonプロジェクトにVisual Inspectionを組み込む</a>
        -   <a href="#gradle-deploy-visual-inspection-sample-for-katalonタスク" id="toc-gradle-deploy-visual-inspection-sample-for-katalonタスク">gradle deploy-visual-inspection-sample-for-katalonタスク</a>
        -   <a href="#gradle-driversタスク" id="toc-gradle-driversタスク">gradle driversタスク</a>
    -   <a href="#visual-inspectionのテストコードを実行してみる" id="toc-visual-inspectionのテストコードを実行してみる">Visual Inspectionのテストコードを実行してみる</a>
    -   <a href="#結論" id="toc-結論">結論</a>

# Visual Inspection : Webサイトの画面確認を自動化しよう

## はじめに

わたしはWebアプリケーションのUIをテストとする作業をソフトウェアで自動化する技術に関心があります。わたしは2018年9月に [Katalon Studio](https://katalon.com/katalon-studio)というUIテスト自動化ツールの体験記をQiitaに投稿しました。

-   [Katalon StudioでVisual Testingを実現した](https://qiita.com/kazurayam/items/bcf72a03f50fc5db4373)

わたしは「Webサイトを画面確認する仕事を自動化したい」と企てたのですが、この時の成果物にはいろいろ不満がありました。わたしはその後も開発を続けました。そしてようやく使い物になるツールに仕立てることができた。このツールを *Visual Inspection* と名付けました。ここでVisual Inspectionを紹介します。読者が触ってみてくれることを希望します。

## Visual Inspectionが出力するレポートのサンプル

Visual Inspectionを実行するとどういう出力が得られるのか？サンプルがあります。下記リンクをクリックして眺めてください。

-   [store/index](https://kazurayam.github.io/inspectus4katalon-sample-project/demo/store/index.html)

このサンプルをブラウザで開きあちこち眺める様子を動画にしてみました。

&lt;iframe width="560" height="315" src="https://www.youtube.com/embed/pxZRS5-rigM" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen&gt;&lt;/iframe&gt;

## サンプルの説明

このレポートの見方を説明しましょう。

### 二つの画像の差分

あるWebページのスクリーンショットを撮り、数秒後にもう一度スクリーンショットを撮って、二つの画像を比較するという検査をしました。違っているピクセルが赤色に塗られる。標的にしたWebページ <http://demoaut-mimic.kazurayam.com/> には秒単位の現在時刻が表示されるのですが、１回目と２回目の間に適当な時間差をおけば時刻が変わるから、差分画像の中に赤い塗りつぶしがわずかながら生じます。こんなふうに：

![Left Diff Right](https://kazurayam.github.io/inspectus4katalon-sample-project/images/Left-Diff-Right.png)

あなたのWebサイトを標的としてVisual Inspectionを実施したら、どのページのどの箇所が赤くなるでしょうか？

### 二つのテキストの差分

標的にしたWebページ <http://demoaut-mimic.kazurayam.com/> のスクリーンショットのなかに赤いところを見つけて「おや？何だこれは」と思ったら、あなたは次に、WebページのHTMLソースコードのどこがどのように違っていたのか、確かめたくなるでしょう。その疑問に即答するために、WebページのHTMLソースをブラウザから取り出して記録として保存しています。下記の画像は二つのHTMLのdiffを表示している例です。

![HTMLsource diff](https://kazurayam.github.io/inspectus4katalon-sample-project/images/HTMLsource_diff.png)

HTMLソースコードだけでなく他のさまざまな形式のテキストを差分検査の対象とすることができます。JSON、XML、CSVといったデータ記述向きのテキストはもちろん、`.js` や `.css` のようなプログラム・コードも差分検査することができます。

### スクリーンショットの一覧

自分が運営するwebサイトのスクリーンショットを撮って一覧レポートを作りたい、ただし差分の検査はとりあえず要らない。そういうシンプルな要求を満たすための機能もサポートしています。次のデモを見てください。検索サイト [DuckDuckGo](https://duckduckgo.com/?) をブラウザで開いて、キーワード `selenium` を指定してENTERし検索結果を見る。その過程で画面のスクリーンショットとHTMLソースを取得し保存する。最後に一覧をHTMLとして生成する。それだけのことをしたサンプルです。

-   [DuckDuckGoのスクリーンショット一覧のデモ](https://kazurayam.github.io/inspectus4katalon-sample-project/demo/store/DuckDuckGo-20221213_080436.html)

![DuckDuckGo small](https://kazurayam.github.io/inspectus4katalon-sample-project/images/DuckDuckGo_small.png)

## Katalon Studioを準備する

前に紹介した `store/index.html` を出力するプロジェクトをあなたのPCで動かしてみましょう。環境を準備することから始めましょう。あなたが Windows10 のPCを持っていてインターネットに接続可能であると前提します。Javaをはじめとするツール類をまったく持っていないと前提して最初から説明します。

### Katalon Studioをインストールする

"Katalon Studio - Standalone Edition"の配布用zipファイルを下記URLからダウンロードすることができます。Standalone Editionは無償で利用できます。わたしの環境ではダウンロードに７分ほどかかりました。

-   <https://katalon.com/download>

![Katalon Download page](https://kazurayam.github.io/inspectus4katalon-sample-project/images/Katalon-Studio-Free-Download-Katalon.png)

"Katalon Studio - Platform Edition" はGUIつきフル機能搭載の製品で有償です。"Katalon Runtime Engine" はCI/CD環境用でコマンドラインでGUI無しに実行するためのバイナリで有償です。これら三種類の製品どれでも Visual Inspection を動かすことができますが、Visual Inspectionのために有償版は必要ありません。

Downloadボタンを押すと "Create a Katalon account" つまりKatalonユーザとしてあなた個人用のアカウントを登録しろと案内されます。

![Sign up Katalon Software Quality Management Platform](https://kazurayam.github.io/inspectus4katalon-sample-project/images/Sign-up-Katalon-Software-Quality-Management-Platform.png)

無償版を使う場合には Full name と Email と Password に適当な文字を入力すればOK。後で必要になるのでメモしておきましょう。有償版を使う場合にはEmailアドレスについて一定の条件を満たすよう求められますがここでは述べません。

Standalone EditionのzipファイルをPCにダウンロードしたらダブルクリックして `Katalon_Studio_Windows_64-x.x.x` フォルダを展開しましょう。どこに配置するかに注意が必要です。あなたのWindowsユーザがフルにWRITE権限を持っているフォルダの下に配置することが必要です。たとえば `C:\Users\あなたのWindowsユーザ名\Katalon_Studio_Windows_64-x.x.x` フォルダを作るのが良いでしょう。しかし `C:\Program Files` フォルダの下に置くとWRITE権限が足りなくてエラーが発生するかもしれない。避けるべきです。`C:\Users\あなたのWindowsユーザ名\Documents` フォルダはひょっとしたら OneDrive と連携して自動バックアップをとる構成になっているかもしれない。そこに大きなバイナリを置くのは避けたほうがいいでしょう。

### Katalon StudioのGUIを起動してユーザー登録をする

展開したフォルダの中に `katalon.exe` がある。これをダブルクリックしてKatalon StudioのGUIを起動します。

![katalon.exe](https://kazurayam.github.io/inspectus4katalon-sample-project/images/katalonexe.png)

初めて起動したときWindowsが「SmartScanが」どうこうとか「Defenderファイアウオールでブロックされています」とかセキュリティに絡む忠告をするかもしれないがあまり気にせず許可してしまいましょう。

Katalon Studioを起動した時、一度だけ、先ほど登録したKatalonユーザとしてのFull nameとEmailとPasswordの入力を求められます。先ほどメモした文字をタイプすればそれでおしまい。有償版だと実働ユーザ数が購入済みライセンスの上限内に収まっているかどうかのチェックがこの段階で作動します。

### Katalon Studio全体にわたる設定をする

#### Proxyを設定する

あなたが会社で仕事に使うPCがプライベートな組織内ネットワークに収容されていて、インターネットにアクセスするのにイントラネットとインターネットの結節点としてのProxyサーバを通過しなければならない環境にあるかもしれない。その場合、Katalon StudioにProxyサーバのIPアドレス等を設定してやる必要があります。下記のドキュメントを参照のこと。

-   [Set Proxy Preferences in Katalon Studio](https://docs.katalon.com/docs/get-started/set-up-your-workspace/katalon-studio-preferences/set-proxy-preferences-in-katalon-studio)

#### WebDriverをアップデートする

Katalon Studioは [Selenium WebDriver](https://www.selenium.dev/documentation/webdriver/) を基盤としています。Katalon StudioがChromeやFireFoxなどのWebブラウザを遠隔操作するために WebDriver と呼ばれる外部モジュールを使います。WebDriverはChromeやFireFoxなどブラウザの種類ごとに別々のモジュールがあり、ブラウザがバージョン・アップするたびにWebDriverモジュールもバージョン・アップされます。Katalon Studioは配布用zipのなかにWebDriverモジュールを同梱していますが、ブラウザが頻繁にバージョン・アップするのでどうしてもzipに格納されたWebDriverモジュールは古くなってしまいます。だからユーザーは適宜自PC上でWebDriverを最新版に更新しなければなりません。この手間仕事を助けるためにKatalon Studioはツールバーに "Update WebDriver" というGUIメニューを備えています。これを使ってWebDriverモジュールを手早く更新することができます。操作については下記ドキュメントを参照のこと。

-   [Upgrade or downgrade WebDrivers](https://docs.katalon.com/docs/legacy/katalon-studio-enterprise/test-design/web-test-design/handle-webdrivers/upgrade-or-downgrade-webdrivers)

#### Scrip viewを使う、Manual viewを使わない

UIテストを具体的に記述したGroovyスクリプトのことをKatalon Studioの用語で Test Case といいます。Test Caseを編集するエディタが装備されているのですが、Test Caseエディタは二つの見た目を備えています。**Manual view** と **Script view** です。Manual viewはぶっちゃけプログラミングのできない人向けのGUIで、Script viewはテキストエディタです。

Visual Inspectionを実装するにはScript viewでGroovyコードを書く必要があります。Manual viewは使いません。ところがKatalon Studioの初期設定ではTest Caseをエディタで開いた時にManual viewを優先して表示します。切り替えるのが煩わしいので最初からScript viewで開くように設定を変更しましょう。

Katalon Studio GUIのツールバー Window &gt; Katalon Studio Preferences &gt; Katalon &gt; Test Case

![Manual view Script view](https://kazurayam.github.io/inspectus4katalon-sample-project/images/Manual_view_Script_view.png)

### プロジェクトを作る

さて、Katalon Studioの中でプロジェクトを作りましょう。

File &gt; New &gt; Project

![New Project](https://kazurayam.github.io/inspectus4katalon-sample-project/images/NewProject.png)

ダイアログが開きます。プロジェクトの名前とプロジェクトをどのフォルダに格納するかを指定します。もちろんあなたの好きなプロジェクト名とフォルダを指定して構いません。

![New Project dialog](https://kazurayam.github.io/inspectus4katalon-sample-project/images/NewProject_dialog.png)

上記のように入力してOKすると `C:\Users\kazurayam\katalon-projects\MyVisualInspectionProject` フォルダが作られ、そのなかに初期状態のフォルダとファイル群が自動生成されます。

### プロジェクトを設定する

新規に作ったプロジェクトの設定をいくつかカスタマイズしておきます。

#### ブラウザの種類を選ぶ

テスト・スクリプトがWebDriverを介してどのWebブラウザを開くかをテスト実行時に選択することができます。Chrome、FireFox、Edge、Safari…​。ただしブラウザを指定せずに ![run](https://kazurayam.github.io/inspectus4katalon-sample-project/images/run_katalon_test.png) ボタンを押してデフォルトとして設定されたブラウザを開くこともできる。どのブラウザを起動するかを設定しておくことができます。

Project &gt; Settings &gt; Execution

![browser default](https://kazurayam.github.io/inspectus4katalon-sample-project/images/browser_default.png)

この例ではChromeブラウザをHeadlessモードで起動することをデフォルトとして選択しています。

#### TestOpsを使わない

Katalon社が提供する [TestOps](https://katalon.com/testops)というサービスがあります。PC上で動くKatalon Studioとインターネット上のサーバで動くTestOpsとを通信させていろいろやる。ただしテストの所要時間がちょっと延びる。デフォルトではTestOpsと連携するように設定されています。しかしVisual InspectionをするためにTest Opsとの連携は不要です。OFFにしましょう。

Project &gt; Settings &gt; Katalon TestOps

![TestOps](https://kazurayam.github.io/inspectus4katalon-sample-project/images/TestOps_integration.png)

#### TestCloudを使わない

TestCloudというサービスとの連携もデフォルトがONになっています。Visual Inspectionするのに不要。OFFにしましょう。

Project &gt; Settings &gt; Katalon TestCloud

![TestCloud](https://kazurayam.github.io/inspectus4katalon-sample-project/images/TestCloud_integration.png)

#### Smart Waitを使わない

Katalon Studioは [Smart Wait](https://katalon.com/resources-center/blog/handle-selenium-wait) という小技を備えています。Smart Waitはときどき悪さをします。本当なら３０秒で終わるはずのテストがSmart Waitのせいで２０分経過したのにまだ終わらないなんてことがたまに起きる。Smart WaitはデフォルトでEnabledの設定になっています。ぜひDisabledにしましょう。

Project &gt; Settings &gt; Execution &gt; WebUI

![SmartWait](https://kazurayam.github.io/inspectus4katalon-sample-project/images/SmartWait.png)

#### Log Viewerを軽量化する

Katalon StudioのGUIの右下にログを表示するエリアがあります。Log Viewerというタブがある。ここを適切に設定しておくべきです。というのもKatalon Studioはテスト実行時にログを大量に吐き出すから。大量のログをLog Viewerに表示する処理が重すぎてテスト開始から終了までの所要時間を長くする原因になる。LogViewerのせいで [本来なら１分で終わるテストが５分以上かかる](https://forum.katalon.com/t/log-viewer-slows-down-your-tests-how-to-prevent-it/60252) なんてことが発生しうる。だからLog Viewerを軽量化しておきましょう。

![Log Viewer](https://kazurayam.github.io/inspectus4katalon-sample-project/images/LogViewer.png)

まずろぐ表示エリアの右上隅にボタンが並んでいるなかにこういうトグルボタンがある。![tree view](https://kazurayam.github.io/inspectus4katalon-sample-project/images/tree_view.png) これを押した状態だと ログ表示部分が Tree 形式になります、ボタンを離した状態だと ログ表示部分がテーブル形式になります、このボタンをOFFして、テーブル形式の表示を選びましょう。Tree表示はCPU負荷が大きく処理遅延の原因になるので使うべきでありません。

ログ表示部をテーブル形式にすると、左側にボタンが並んで表示されます。All、Info、Passed、Failed、Error、Warning、Not Run とラベルされたボタンがあって、デフォルトでは Allボタン がONになっています。AllがONだと "START xxxx" "END xxxx" というログが大量に出力されます。このログは役に立たないし、あまりに多いので処理遅延の原因になります。Allを必ずOFFにしましょう。

以上で `MyVisualInspectionProject` プロジェクトを設定することができました。

### 初めてのTest Caseを作って動かしてみる

では　Katalon Studioのプロジェクトにごく単純なTest Caseスクリプトをひとつ作って実行してみましょう。わたしは `Test Cases/sample/47news` を作りました。内容は下記の通り。

1.  Webブラウザを開き

2.  或るURLを表示して

3.  数秒待って

4.  ブラウザを閉じる

<!-- -->

    import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

    WebUI.openBrowser('')
    WebUI.navigateToUrl('https://www.47news.jp/')
    WebUI.delay(3)   // stay still for 3 seconds
    WebUI.closeBrowser()

このスクリプト実行するには、Katalon Studioのウインドウの上部に配置された緑色の矢印のボタン ![run button](https://kazurayam.github.io/inspectus4katalon-sample-project/images/run_katalon_test.png)を押します。

このTest Caseを開いて実行するまでの操作を動画にしてみました。

<https://youtu.be/4jT6pgDmxmc>

&lt;iframe width="560" height="315" src="https://www.youtube.com/embed/4jT6pgDmxmc" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen&gt;&lt;/iframe&gt;

以上で、Katalon Studioでプロジェクトを作りテストスクリプトを作って動かすことができました。

## ビルドツール Gradle を準備する

Visual Inspectionを実行できるようにコードを作り込んだプロジェクトのサンプルが下記のGitHubレポジトリにあります。わたくしkazurayamが作りました。

-   <https://github.com/kazurayam/inspectus4katalon-sample-project>

[Qiita](https//qiita.com/)の読者ならこのGitHubプロジェクトを `git clone` してWindows PC上のKatalon Studioで動かすことができるでしょう。その方法だと応用が効きません。あなたがWindows10 PCでKatalonプロジェクトを作り、自分のwebサイトを画面確認する作業を自動化するのに役立たない。ここでは `git clone` するのではなく、別の方法を紹介します。ビルドツール [Gradle](https://gradle.org/) を使います。

Gradleを使うために準備が必要です。道筋を先に説明しましょう。

1.  あなたはKatalon Studioでプロジェクトを一つ自作する。

2.  kazurayamはVisual Inspectionを実行するのに必要なライブラリ一式とサンプルコードを某所からダウンロードしてあなたのプロジェクトに組み込むことができる仕組みを準備しました。

3.  ダウンロードと組み込みの処理をJavaのビルドツール [Gradle](https://gradle.org/) を使って行う。だからあなたのWindows PCにGradleをインストールしたい。

4.  Gradleを動かすためにはJava実行環境が必要です。だからJavaもインストールしなければならない。

5.  Windows PCにJavaとGradleをインストールするには [SDKMAN!](https://sdkman.io/) を使うのが良い。だからあなたのWindows PCにSDKMAN!をインストールしたい。

6.  SDKMAN!をインストールするには [curl](https://curl.se/) コマンドを使う。

7.  残念ながらcurlコマンドはWindowsにあらかじめ組み込まれていない。curlを使える環境をWindows上に作る必要がある。そこで [Git for Windows](https://gitforwindows.org/) をインストールする。Git for Windowsをインストールするとオマケとして Git Bash というWindowsプログラムがインストールされる。

8.  Git Bashを起動し、curlコマンドでSDKMAN!をインストールし、SDKMANでJavaとGradleをインストールする。

9.  最後にあなたのKatalonプロジェクトに `build.gradle` ファイルを作り数行のコードを記述したら、gradleタスクを2回実行する。するとライブラリとサンプルコードがプロジェクトに組み込まれる。

以上が作業全体の流れです。ではひとつひとつ、やっていきましょう。

### Git for Windowsをインストールする

-   [Git for Windows](https://gitforwindows.org/)

このサイトのdownloadボタンを押します。インストーラーがダウンロードできます。インストーラーを実行してください。すべてデフォルトの設定を選択するのでいい。インストールが完了すると `Git Bash` が使えるようになります。

![Git Bash](https://kazurayam.github.io/inspectus4katalon-sample-project/images/git_bash.png)

### SDKMAN!をインストールする

SDKMAN!のページ　[SDKMAN!](https://sdkman.io/) をみると、terminalでこのコマンドを実行しろ！と書いてあります。

`curl -s "https://get.sdkman.io" | bash`

Git Bashのウインドウを開いてこのコマンドを実行してください。

![curl get sdkman](https://kazurayam.github.io/inspectus4katalon-sample-project/images/curl_get_sdkman.png)

ダーーっとメッセージが出力されてインストールが完了するでしょう。うまく行ったかどうかを確認するために、バージョンを表示してみましょう。

    $ sdk version

    SDKMAN 5.xx.xx

というような表示がされればOKです。

SDKMAN!のコマンドについてはドキュメント [SDKMAN! usage](https://sdkman.io/usage) を参照のこと。

### Javaをインストールする

ではSDKMAN!を使ってJavaをインストールしましょう。Git Bashのコマンドラインで下記のコマンドを実行します。

    $ sdk install java

だー〜っとメッセージが出力されて終了したらJavaの最新安定版がインストールされているはず。javaコマンドを動かしてみましょう。

    $ java --verison
    openjdk 17.0.5 2022-10-18
    OpenJDK Runtime Environment Temurin-17.0.5+8 (build 17.0.5+8)
    OpenJDK 64-BIt Server VM Temurin-17.0.5+8 (build 17.0.5+8, mixed mode, sharing)

こんな感じの応答があれば大丈夫。別バージョンでもかまいません。

### Gradleをインストールする

続けてSDKMAN!を使ってGradleをインストールしましょう。Git Bashのコマンドラインで下記のコマンドを実行します。

    $ sdk install gradle

だー〜っとメッセージが出力されて終了したらGradleの最新安定版がインストールされているはず。gradleコマンドを動かしてみましょう。

    $ gradle --version

    ----------------------------------------------------------
    Gradle 7.6
    ----------------------------------------------------------
    ...

こんな感じの応答があれば大丈夫。別バージョンでもかまいません。

さて、ようやくビルドツール Gradle を使える環境が整いました。

## 自作のKatalonプロジェクトにVisual Inspectionを組み込む

Katalon Studioをインストールし、ビルドツール Gradle を動かす準備もできました。ではKatalon Studioでプロジェクトを作って画面確認を自動化しましょう。

Katalonプロジェクトの作り方は前に説明しました。以下では `C:\Users\あなたのWindowsユーザ名\katalon-projects` フォルダのなかに `MyVisualInspectionProject` という名前のプロジェクトを作ったと仮定して説明します。

`MyVisualInspectionProject` フォルダの直下に `build.gradle` ファイルがあるはずです。あなたがプロジェクトを最初に作ったときにKatalon Studioが build.gradle を自動生成しました。ただし実はKatalon Studio(現時点のバージョンは8.5.x)はbuild.gradleファイルをまったく利用していません。削除してもかまわないし書きかえてもKatalon Studio本体の動きには影響しません。

そこでbuild.gradleファイルを下記のように書きかえて保存します。`com.kazurayam.inspectus4katalon` はkazurayamが開発したカスタムGradleプラグインです。 [Gradle Plugin Portal](https://plugins.gradle.org/plugin/com.kazurayam.inspectus4katalon) で公開しています。

    plugins {
      id 'com.kazurayam.inspectus4katalon' version "0.4.0"
    }

Katalon Studioを一旦停止してください。そしてGit Bashのウインドウを開いてKatalonプロジェクトのフォルダに移動します。

    $ cd ~/katalon-projects/MyVisualInspectionProject

### gradle deploy-visual-inspection-sample-for-katalonタスク

では、サンプルコードをダウンロードして組み込みましょう。Git Bashのコマンドラインで次のコマンドを実行してください。

    $ gradle deploy-visual-inspection-sample-for-katalon

すると次のようなメッセージが出力されるはず。

    Starting a Gradle Daemon (subsequent builds will be faster)

    > Task :deploy-visual-inspection-sample-for-katalon
    Downloading https://github.com/kazurayam/inspectus4katalon-sample-project/releases/download/0.4.0/distributable.zip into C:\Users\kazurayam\katalon-projects\MyVisualInspectionProject\build\tmp\distributable.zip
    ... Include/data/MyAdmin/targetList.csv
    ... Object Repository/CURA/Page_CURA Healthcare Service/appointment/button_Book Appointment.rs
    ... Object Repository/CURA/Page_CURA Healthcare Service/appointment/input_Apply for hospital readmission.rs
    ... Object Repository/CURA/Page_CURA Healthcare Service/appointment/input_Medicaid_programs.rs
    ... Object Repository/CURA/Page_CURA Healthcare Service/appointment/input_visit_date.rs
    ... Object Repository/CURA/Page_CURA Healthcare Service/appointment/select_Tokyo CURA Healthcare Center.rs
    ... Object Repository/CURA/Page_CURA Healthcare Service/appointment/textarea_Comment_comment.rs
    ... Object Repository/CURA/Page_CURA Healthcare Service/login/button_Login.rs
    ... Object Repository/CURA/Page_CURA Healthcare Service/login/input_Password_password.rs
    ... Object Repository/CURA/Page_CURA Healthcare Service/login/input_Username_username.rs
    ... Object Repository/CURA/Page_CURA Healthcare Service/summary/a_Go to Homepage.rs
    ... Object Repository/CURA/Page_CURA Healthcare Service/top/a_Make Appointment.rs
    ... Profiles/CURA_DevelopmentEnv.glbl
    ... Profiles/MyAdmin_DevelopmentEnv.glbl
    ... Profiles/MyAdmin_ProductionEnv.glbl
    ... Scripts/common/BackupAll/Script1668394619253.groovy
    ... Scripts/common/Scavenge/Script1668394684813.groovy
    ... Scripts/CURA/main/Script1667709715867.groovy
    ... Scripts/CURA/materialize/Script1667709728945.groovy
    ... Scripts/CURA/run_materialize/Script1667709743309.groovy
    ... Scripts/DuckDuckGo/main/Script1667437517277.groovy
    ... Scripts/DuckDuckGo/materialize/Script1667437527092.groovy
    ... Scripts/DuckDuckGo/run_materialize/Script1667616595404.groovy
    ... Scripts/MyAdmin/main/Script1667687348266.groovy
    ... Scripts/MyAdmin/materialize/Script1667687365090.groovy
    ... Scripts/MyAdmin/processTargetList/Script1668563538525.groovy
    ... Scripts/MyAdmin/run_materialize/Script1667687380074.groovy
    ... Test Cases/common/BackupAll.tc
    ... Test Cases/common/Scavenge.tc
    ... Test Cases/CURA/main.tc
    ... Test Cases/CURA/materialize.tc
    ... Test Cases/CURA/run_materialize.tc
    ... Test Cases/DuckDuckGo/main.tc
    ... Test Cases/DuckDuckGo/materialize.tc
    ... Test Cases/DuckDuckGo/run_materialize.tc
    ... Test Cases/MyAdmin/main.tc
    ... Test Cases/MyAdmin/materialize.tc
    ... Test Cases/MyAdmin/processTargetList.tc
    ... Test Cases/MyAdmin/run_materialize.tc
    deployed the sample project v0.4.0

    BUILD SUCCESSFUL in 16s
    1 actionable task: 1 executed

`deploy-visual-inspection-sample-for-katalon` タスクが何をやったか？ GitHub上にある inspectus4katalon-sample-projectレポジトリの [Releasesページ](https://github.com/kazurayam/inspectus4katalon-sample-project/releases/tag/0.4.0) に `distributable.zip` ファイルが添付されている。このzipのなかにVisual Inspectionのサンプルコード一式が格納されている。`deploy-visual-inspection-sample-for-katalon` タスクはzipファイルをダウンロードして解凍し、カレント・ディレクトリに上書きします。上記のメッセージはこの時copyされたファイルのパスを表示しています。

### gradle driversタスク

もうひとつ、コマンドを実行します。

    kazurayam@DESKTOP-VQERHGD MINGW64 ~/katalon-projects/MyVisualInspectionProject

    $ gradle drivers

    > Task :drivers
    inspectus-0.9.0.jar
    ExecutionProfilesLoader-1.2.1.jar
    materialstore-0.16.0.jar
    ashot-1.5.4.jar
    commons-csv-1.9.0.jar
    jsoup-1.14.3.jar
    freemarker-2.3.31.jar
    java-diff-utils-4.11.jar

    BUILD SUCCESSFUL in 7s
    1 actionable task: 1 executed

このコマンドが完了すると、MyVisualInspectionProjectのルートフォルダの直下にある `Drivers` フォルダのなかにいくつかのjarファイルが配置されます。確認してみましょう。

    kazurayam@DESKTOP-VQERHGD MINGW64 ~/katalon-projects/MyVisualInspectionProject
    $ ls -la ./Drivers
    total 2696
    drwxr-xr-x 1 kazurayam 197609       0 12月 22 23:09 ./
    drwxr-xr-x 1 kazurayam 197609       0 12月 22 22:54 ../
    -rw-r--r-- 1 kazurayam 197609   54351 12月 22 23:09 AUTOIMPORTED_ashot-1.5.4.jar
    -rw-r--r-- 1 kazurayam 197609   51322 12月 22 23:09 AUTOIMPORTED_commons-csv-1.9.0.jar
    -rw-r--r-- 1 kazurayam 197609   89290 12月 22 23:09 AUTOIMPORTED_ExecutionProfilesLoader-1.2.1.jar
    -rw-r--r-- 1 kazurayam 197609 1715750 12月 22 23:09 AUTOIMPORTED_freemarker-2.3.31.jar
    -rw-r--r-- 1 kazurayam 197609   63826 12月 22 23:09 AUTOIMPORTED_inspectus-0.9.0.jar
    -rw-r--r-- 1 kazurayam 197609   69437 12月 22 23:09 AUTOIMPORTED_java-diff-utils-4.11.jar
    -rw-r--r-- 1 kazurayam 197609  423395 12月 22 23:09 AUTOIMPORTED_jsoup-1.14.3.jar
    -rw-r--r-- 1 kazurayam 197609  269269 12月 22 23:09 AUTOIMPORTED_materialstore-0.16.0.jar

これらはVisual Inspectionを実行するのに必要な外部モジュールです。しかしKatalon Studio本体のzipには同梱されていなかったもので、正味追加しなければならないものです。 [`materialstore`](https://github.com/kazurayam/materialstore) と [`inspectus`](https://github.com/kazurayam/inspectus) というjarファイルがVisual Inspectionの実装コードを格納しています。どちらもkazurayamが開発して [Maven Centralレポジトリ](https://mvnrepository.com/artifact/com.kazurayam) で公開しています。

## Visual Inspectionのテストコードを実行してみる

さてKatalon Studioを再起動しましょう。MyVisualInspectionProjectを開いてください。画面左側に `Test Cases` フォルダがある。そこを開くと `CURA`、`DuckDuckGo`、 `MyAdmin` というフォルダがある。それらフォルダを開くと各々に `main` という名前のTest Caseスクリプトがあります。

![sample test cases installed](https://kazurayam.github.io/inspectus4katalon-sample-project/images/SampleTestCasesInstalled.png)

`main` を開いてボタン ![green run](https://kazurayam.github.io/inspectus4katalon-sample-project/images/run_katalon_test.png) を押せばスクリプトが実行されます。`main` が走り終わるとプロジェクトのルート直下に `store` という名前のフォルダが作られます。そのなかに `index.html` ができています。

![store/index just created](https://kazurayam.github.io/inspectus4katalon-sample-project/images/store_index_just_created.png)

ただしKatalon Studioに不具合があって、プロジェクトのフォルダの直下に作られた `store` フォルダをただちに表示してくれません。いったんMyVisualInspectionProjectを閉じてもう一度開いてください。そうすれば `store` フォルダが見えるはず。

`index.html` をダブルクリックすればブラウザで開きます。それこそが本投稿の冒頭で紹介したサンプル

-   [store/index](https://kazurayam.github.io/inspectus4katalon-sample-project/demo/store/index.html)

にほかなりません。

## 結論

わたしが開発したWebサイトの画面確認を自動化するツール Visual Inspection を紹介しました。読者がVisual Inspectionを応用して自分の興味あるWebサイトの画面確認を自動化するツールを構築することがきます。本投稿では、実行環境を作る手順とサンプルコードを説明しました。読者が自分の仕事に役立つツールを構築するには、対象となるWebサイトのスクリーンショットを撮る処理をGroovy言語で自作する必要があります。長くなるのでここではプログラミングの詳細を説明しません。別の投稿で述べようと思います。
