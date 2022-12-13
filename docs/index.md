# inspectus4katalon-sample-project

-   back to the [repository](https://kazurayam.github.io/inspectus4katalon-sample-project/)

## Demonstration

### index

-   [store/index.html](https://kazurayam.github.io/inspectus4katalon-sample-project/demo/store/index.html)

### How "Test Cases/DuckDuckGo" works

-   The Test Case [DuckDuckGo/main](https://github.com/kazurayam/inspectus4katalon-sample-project/tree/master/Scripts/DuckDuckGo/main/Script1667437517277.groovy) visits a single Web site.

-   It navigates through the site for a few web pages.

-   It takes screenshots of the pages, save the images in PNG format. It also save the HTML sources.

-   It compiles a report in HTML where you can see a list of all files saved during the run.

Demo in action: [click here](https://kazurayam.github.io/inspectus4katalon-sample-project/demo/store/DuckDuckGo-20221213_080436.html)

![shootings](diagrams/out/shootings/shootings.png)

The Test Case [DuckDuckGo/main](https://github.com/kazurayam/inspectus4katalon-sample-project/tree/master/Scripts/DuckDuckGo/main/Script1667437517277.groovy) sets up the parameters and calls the Test Case [DuckDuckGo/materialize](https://github.com/kazurayam/inspectus4katalon-sample-project/tree/master/Scripts/DuckDuckGo/materialize/Script1667437527092.groovy). The `main` testcase executes `com.kazurayam.inspectus.katalon.KatalonShootings` object, which performs all diffing and reporting tasks etc behind the scene.

The Test Case [DuckDuckGo/materialize](https://github.com/kazurayam/inspectus4katalon-sample-project/tree/master/Scripts/DuckDuckGo/materialize/Script1667437527092.groovy) is essentially an ordinary Katalon Studio’s test case. You are totally responsible which URL to open, how to navigate through, how to take screenshots, how to write the files. It is required to write the files into the `store` object. See [materialstore tutorial](https://kazurayam.github.io/materialstore-tutorial/) for more information of the API.

You can run the test case [Test Case/DuckDuckGo/run\_materialize](https://github.com/kazurayam/inspectus4katalon-sample-project/tree/master/Scripts/DuckDuckGo/run_materialize/Script1667616595404.groovy) to test the `DuckDuckGo/materialize` on its own.

### How "Test Cases/CURA" works

-   The Test Case [CURA/main](https://github.com/kazurayam/inspectus4katalon-sample-project/tree/master/Scripts/CURA/main/Script1667709715867.groovy) visits a single Web site

-   You want to run Test Case "CURA/main" twice. You may wait for some duration (seconds, minutes, hours, …​) as long as you want. You should determine how large the chronological gap should be; you are to determine when to run the 2nd time.

-   It navigates through the site for a few web pages.

-   It takes screenshots of the pages, save the images in PNG format. It also save the HTML sources.

-   It compiles a report in HTML where you find multiple sets of **Previous** / **Diff** / **Current** images & HTMLs of the web site taken at different timing.

-   By Chronos-Diff, you can compare the pages of a single Web site at different timing. You can make sure if your Web application is healthy after certain changes in any portion of software/hardware/network.

Demo in action:

-   [1st run](https://kazurayam.github.io/inspectus4katalon-sample-project/demo/store/CURA-20221213_080716.html)

-   [2nd run](https://kazurayam.github.io/inspectus4katalon-sample-project/demo/store/CURA-20221213_080831.html)

![chronos diff](diagrams/out/chronos-diff/chronos-diff.png)

The Test Case [CURA/main](https://github.com/kazurayam/inspectus4katalon-sample-project/tree/master/Scripts/CURA/main/Script1667709715867.groovy) sets up the parameters and calls the Test Case [CURA/materialize](https://github.com/kazurayam/inspectus4katalon-sample-project/tree/master/Scripts/CURA/materialize/Script1667709728945.groovy). The `main` testcase executes `com.kazurayam.inspectus.katalon.KatalonChronosDiff` object, which performs all diffing and reporting tasks etc behind the scene.

The Test Case [CURA/materialize](https://github.com/kazurayam/inspectus4katalon-sample-project/tree/master/Scripts/CURA/materialize/Script1667709728945.groovy) is essentially an ordinary Katalon Studio’s test case. You are totally responsible which URL to open, how to navigate through, how to take screenshots, how to write the files. It is required to write the files into the `store` object. See [materialstore tutorial](https://kazurayam.github.io/materialstore-tutorial/) for more information of the API.

You can run the test case [Test Case/CURA/run\_materialize](https://github.com/kazurayam/inspectus4katalon-sample-project/tree/master/Scripts/CURA/run_materialize/Script1667709743309.groovy) to test the `DuckDuckGo/materialize` on its own.

### How "Test Cases/MyAdmin" works

-   The Test Case [CURA/main](https://github.com/kazurayam/inspectus4katalon-sample-project/tree/master/Scripts/CURA/main/Script1667709715867.groovy) visits 2 Web sites which have the same sitemap; namely Production environment and Development environment.

-   It navigates through the site for multiple pages.

-   It reads a CSV file to know the list of URLs to process.

-   It processes 2 Web sites sequentially as soon as possible without putting any time gap.

-   It takes screenshots of the pages, save the images in PNG format. It also save the HTML sources.

-   It compiles a report in HTML where you find multiple sets of **Previous** / **Diff** / **Current** images & HTMLs of the web site taken at almost the same timing.

-   By Twins-Diff, you can compare the Production environment and the Development environment.

Demo in action: [click here](https://kazurayam.github.io/inspectus4katalon-sample-project/demo/store/MyAdmin-20221213_080556.html)

![twins diff](diagrams/out/twins-diff/twins-diff.png)

The Test Case [MyAdmin/main](https://github.com/kazurayam/inspectus4katalon-sample-project/tree/master/Scripts/MyAdmin/main/Script1667687348266.groovy)w sets up the parameters and calls the Test Case [MyAdmin/materialize](https://github.com/kazurayam/inspectus4katalon-sample-project/tree/master/Scripts/MyAdmin/materialize/Script1667687365090.groovy). The `main` testcase executes `com.kazurayam.inspectus.katalon.KatalonTwinsDiff` object, which performs all diffing and reporting tasks etc behind the scene.

The Test Case [MyAdmin/materialize](https://github.com/kazurayam/inspectus4katalon-sample-project/tree/master/Scripts/MyAdmin/materialize/Script1667687365090.groovy) is essentially an ordinary Katalon Studio’s test case. You are totally responsible which URL to open, how to navigate through, how to take screenshots, how to write the files. It is required to write the files into the `store` object. See [materialstore tutorial](https://kazurayam.github.io/materialstore-tutorial/) for more information of the API.

You can run the test case [Test Case/MyAdmin/run\_materialize](https://github.com/kazurayam/inspectus4katalon-sample-project/tree/master/Scripts/MyAdmin/run_materialize/Script1667687380074.groovy) to test the \` MyAdmin/materialize\` on its own.
