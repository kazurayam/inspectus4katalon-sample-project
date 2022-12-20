-   <a href="#visual-inspection-webサイトの画面確認を自動化しよう" id="toc-visual-inspection-webサイトの画面確認を自動化しよう">Visual Inspection : Webサイトの画面確認を自動化しよう</a>
    -   <a href="#はじめに" id="toc-はじめに">はじめに</a>
    -   <a href="#visual-inspectionが出力するレポートのサンプル" id="toc-visual-inspectionが出力するレポートのサンプル">Visual Inspectionが出力するレポートのサンプル</a>
    -   <a href="#サンプルの説明" id="toc-サンプルの説明">サンプルの説明</a>
        -   <a href="#二つの画像の差分" id="toc-二つの画像の差分">二つの画像の差分</a>
        -   <a href="#二つのテキストの差分" id="toc-二つのテキストの差分">二つのテキストの差分</a>
        -   <a href="#スクリーンショットの一覧" id="toc-スクリーンショットの一覧">スクリーンショットの一覧</a>

# Visual Inspection : Webサイトの画面確認を自動化しよう

## はじめに

わたしはWebアプリケーションのUIをテストとする作業をソフトウェアで自動化する技術に関心があります。わたしは2018年9月に下記の記事をQiitaに投稿しました。

-   [Katalon StudioでVisual Testingを実現した](https://qiita.com/kazurayam/items/bcf72a03f50fc5db4373)

このとき実装したコードにいろいろ不満があった。わたしは開発を続けました。もう４年も経った。ようやく実用レベルのツールを仕上げることができたのでここで紹介します。このツールを *Visual Inspection* と名付けます。

## Visual Inspectionが出力するレポートのサンプル

Visual Inspectionを実行するとどういう出力が得られるのか？サンプルがあります。下記リンクをクリックして眺めてください。

-   [store/index](https://kazurayam.github.io/inspectus4katalon-sample-project/demo/store/index.html)

このサンプルをブラウザで開きあちこち眺める様子を動画にしてみました。

&lt;iframe width="560" height="315" src="https://www.youtube.com/embed/pxZRS5-rigM" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen&gt;&lt;/iframe&gt;

## サンプルの説明

このレポートの見方をざっと説明しましょう。

### 二つの画像の差分

上記URLが見せるサンプルの一つは、あるWebページのスクリーンショットを撮り、数秒後にもう一度スクリーンショットを撮って、二つの画像をピクセル単位で比較した結果の画像を見せている。食い違っているピクセルが赤色に塗られてハイライトされている。ここで題材にしたWebページ <http://demoaut-mimic.kazurayam.com/> には現在時刻が秒単位で表示される。適当に間隔をおいて2回目のリクエストをすれば時刻が変わるのでわずかながら差分画像の中に赤い塗りつぶしが生じる。その様子をデモしています。

![Left Diff Right](https://kazurayam.github.io/inspectus4katalon-sample-project/images/Left-Diff-Right.png)

あなたのWebサイトを標的としてVisual Inspectionを実施したら、どのページのどの箇所が赤くなるだろうか？ --- それはやってみなければわからない。ぜひ自分で試してみてください。

### 二つのテキストの差分

題材にしたWebページ <http://demoaut-mimic.kazurayam.com/> のスクリーンショットで赤い塗り潰しを見つけて「おや？どうしてこうなったんだ」と気づいたら、あなたはWebページのHTMLソースコードのどこがどのように違っているのか、すぐに確かめたくなるだろう。その疑問に即答するべくデモはWebページのHTMLソースをブラウザから取り出して記録として保存しています。下記の画像は二つのHTMLのdiffを表示している例です。

![HTMLsource diff](https://kazurayam.github.io/inspectus4katalon-sample-project/images/HTMLsource_diff.png)

この例はブラウザに表示されたWebページのHTMLソースコードを題材としたが、他の形式のテキストも差分検査の対象とすることができる。JSON、XML、CSVといったデータ記述向きのテキストはもちろん、`.js` や `.css` のようなプログラム・コードもinspectすることができる。つまりWebサイトからテキストファイルをダウンロードしていったんディスクに保存する。それを二度やる。その後、二つのファイルを比較して差分を検査することができる。

### スクリーンショットの一覧

自分が運営するwebサイトのスクリーンショットをたくさん撮って一覧したい、差分検査はとりあえず要らない。そういうシンプルな要求を満たすための機能もサポートしています。次のデモを見てください。検索サイト [DuckDuckGo](https://duckduckgo.com/?) をブラウザで開いて、キーワード `selenium` を指定してENTERし検索結果を見る。その途中で画面のスクリーンショットとHTMLソースを取得し保存する。そして一覧画面でHTMLとして生成する。これだけのことをしたデモです。

-   [DuckDuckGoのスクリーンショット一覧のデモ](https://kazurayam.github.io/inspectus4katalon-sample-project/demo/store/DuckDuckGo-20221213_080436.html)

![DuckDuckGo small](images/DuckDuckGo_small.png)
