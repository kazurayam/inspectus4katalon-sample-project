# inspectus4katalon-sample-project

-   back to the [repository](https://kazurayam.github.io/inspectus4katalon-sample-project/)

## Demonstration

### Sample reports

-   [store/index.html](https://kazurayam.github.io/inspectus4katalon-sample-project/demo/store/index.html)

### How "Test Cases/DuckDuckGo" works

-   It visits a single Web site.

-   It navigates through the site for a few web pages.

-   It takes screenshots of the pages, save the images in PNG format. It also save the HTML sources.

-   It compiles a report in HTML where you can see a list of all files saved during the run.

Demo in action: [click here](https://kazurayam.github.io/inspectus4katalon-sample-project/demo/store/DuckDuckGo-20221213_080436.html)

![shootings](diagrams/out/shootings/shootings.png)

### How "Test Cases/CURA" works

-   It visits a single Web site

-   It navigates through the site for a few web pages.

-   You want to run Test Case "CURA/main" twice. You may wait for some duration (seconds, minutes, hours, …​) as long as you want. You should determine the chronological gap; you should determine when to run the 2nd time.

-   It takes screenshots of the pages, save the images in PNG format. It also save the HTML sources.

-   It compiles a report in HTML where you find multiple sets of **Previous** / **Diff** / **Current** images & HTMLs of the web site taken at different timing.

-   By Chronos-Diff, you can compare the pages of a single Web site at different timing. You can make sure if your Web application is healthy after certain changes in any portion of software/hardware/network.

Demo in action:
\* [1st run](https://kazurayam.github.io/inspectus4katalon-sample-project/demo/store/CURA-20221213_080716.html)
\* [2nd run](https://kazurayam.github.io/inspectus4katalon-sample-project/demo/store/CURA-20221213_080831.html)

![chronos diff](diagrams/out/chronos-diff/chronos-diff.png)

### How "Test Cases/MyAdmin" works

-   It visits 2 Web sites which have the same sitemap; namely Production environment and Development environment.

-   It navigates through the site for multiple pages.

-   It reads a CSV file to know the list of URLs to process.

-   It processes 2 Web sites sequentially as soon as possible without putting any time gap.

-   It takes screenshots of the pages, save the images in PNG format. It also save the HTML sources.

-   It compiles a report in HTML where you find multiple sets of **Previous** / **Diff** / **Current** images & HTMLs of the web site taken at almost the same timing.

-   By Twins-Diff, you can compare the Production environment and the Development environment.

Demo in action: [click here](https://kazurayam.github.io/inspectus4katalon-sample-project/demo/store/MyAdmin-20221213_080556.html)

![twins diff](diagrams/out/twins-diff/twins-diff.png)
