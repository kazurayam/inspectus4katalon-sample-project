-   <a href="#automated-visual-inspection" id="toc-automated-visual-inspection">Automated Visual Inspection</a>
    -   <a href="#introduction" id="toc-introduction">Introduction</a>
    -   <a href="#sample-output-from-the-visual-inspection" id="toc-sample-output-from-the-visual-inspection">Sample output from the Visual Inspection</a>
    -   <a href="#explanation-of-the-sample-output" id="toc-explanation-of-the-sample-output">Explanation of the sample output</a>
        -   <a href="#difference-report-between-2-screenshots" id="toc-difference-report-between-2-screenshots">Difference report between 2 screenshots</a>
        -   <a href="#difference-report-between-2-html-source-texts" id="toc-difference-report-between-2-html-source-texts">Difference report between 2 HTML source texts</a>
        -   <a href="#list-of-screenshots" id="toc-list-of-screenshots">List of screenshots</a>
    -   <a href="#installing-and-setting-up-katalon-studio" id="toc-installing-and-setting-up-katalon-studio">Installing and setting up Katalon Studio</a>
        -   <a href="#installing-katalon-studio" id="toc-installing-katalon-studio">Installing Katalon Studio</a>
        -   <a href="#launching-katalon-studio" id="toc-launching-katalon-studio">Launching Katalon Studio</a>
        -   <a href="#configure-katalon-studio" id="toc-configure-katalon-studio">Configure Katalon Studio</a>
            -   <a href="#proxy" id="toc-proxy">Proxy</a>
            -   <a href="#update-webdriver-modules" id="toc-update-webdriver-modules">Update WebDriver modules</a>
            -   <a href="#use-script-view-not-manual-view-in-the-test-case-editor" id="toc-use-script-view-not-manual-view-in-the-test-case-editor">Use Script view, not Manual view, in the Test Case editor</a>
        -   <a href="#create-a-project" id="toc-create-a-project">Create a project</a>
        -   <a href="#setting-up-the-project" id="toc-setting-up-the-project">Setting up the project</a>
            -   <a href="#choose-type-of-browser-as-default" id="toc-choose-type-of-browser-as-default">Choose type of browser as default</a>
            -   <a href="#no-testops" id="toc-no-testops">No TestOps</a>
            -   <a href="#no-testcloud" id="toc-no-testcloud">No TestCloud</a>
            -   <a href="#disable-smart-wait" id="toc-disable-smart-wait">Disable Smart Wait</a>
            -   <a href="#tune-log-viewer-light-weighted" id="toc-tune-log-viewer-light-weighted">Tune Log Viewer light-weighted</a>
        -   <a href="#creating-your-first-test-case" id="toc-creating-your-first-test-case">Creating your first Test Case</a>
    -   <a href="#setting-up-gradle-build-tool" id="toc-setting-up-gradle-build-tool">Setting up Gradle build tool</a>
        -   <a href="#installing-git-for-windows" id="toc-installing-git-for-windows">Installing Git for Windows</a>
        -   <a href="#installing-sdkman" id="toc-installing-sdkman">Installing SDKMAN!</a>
        -   <a href="#installing-java" id="toc-installing-java">Installing Java</a>
        -   <a href="#installing-gradle" id="toc-installing-gradle">Installing Gradle</a>
    -   <a href="#inject-the-resources-required-for-visual-inspection-into-your-own-katalon-project" id="toc-inject-the-resources-required-for-visual-inspection-into-your-own-katalon-project">Inject the resources required for Visual Inspection into your own Katalon project</a>
        -   <a href="#gradle-deploy-visual-inspection-sample-for-katalon" id="toc-gradle-deploy-visual-inspection-sample-for-katalon">gradle deploy-visual-inspection-sample-for-katalon</a>
        -   <a href="#gradle-drivers-task" id="toc-gradle-drivers-task">gradle drivers task</a>
    -   <a href="#lets-run-the-sample-code-of-visual-inspection" id="toc-lets-run-the-sample-code-of-visual-inspection">Let’s run the sample code of Visual Inspection</a>
    -   <a href="#conclusion" id="toc-conclusion">Conclusion</a>

# Automated Visual Inspection

-   @author kazurayam

-   @date Dec 2022

-   back to the [repository](https://github.com/kazurayam/inspectus4katalon-sample-project)

## Introduction

I am interested in the technology to automate verifying the UI of Web applications visually. I have ever posted about the same issue in the Katalon forum previously:

-   [Visual Inspection in Katalon Studio - Reborn, Aug '21](https://forum.katalon.com/t/visual-inspection-in-katalon-studio-reborn/57440)

I was not satisfied with this version of my product. I continued working on it and could finally produce something more favorable. I will call the tool as "Visual Inspection" for short. Here I will present it to you. I would be glad if you could spare your time playing on it a bit.

## Sample output from the Visual Inspection

What sort of output does my Visual Inspection produces? Here is a sample. Click it to see:

-   [store/index](https://kazurayam.github.io/inspectus4katalon-sample-project/demo/store/index.html)

Here is a video that shows how you can retrieve the pages of the sample output:

&lt;iframe width="560" height="315" src="https://www.youtube.com/embed/pxZRS5-rigM" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen&gt;&lt;/iframe&gt;

## Explanation of the sample output

Let me explain the sample output.

### Difference report between 2 screenshots

I took a screenshot of a web page and later took another screenshot, then I took a diff of 2 images. The sample includes an output of this image comparison feature. The targeted Web page <http://demoaut-mimic.kazurayam.com/> shows the current timestamp in seconds unit, which changes in some time interval. The change of time makes some image differences. The differences are painted red as follows:

![Left Diff Right](https://kazurayam.github.io/inspectus4katalon-sample-project/images/Left-Diff-Right.png)

### Difference report between 2 HTML source texts

When you find some region painted red in the diff image, then you would be interest to know more why. You would certainly want to read the HTML source codes of 2 timings. The sample includes the HTML source taken out of the web page. The following image shows how the sample presents the diff of HTMLs.

![HTMLsource diff](https://kazurayam.github.io/inspectus4katalon-sample-project/images/HTMLsource_diff.png)

Using Katalon Studio, you can download and save many kinds of texts out of the web; not only HTML source but also JSON, XML, CSV, .js, .css. Once saved, Visual Inspection can create diff reports of any kind of those texts.

### List of screenshots

The sample output includes a simple list of screenshots without diff. Please look at the following link:

-   [list of screenshots of DuckDuckGo](https://kazurayam.github.io/inspectus4katalon-sample-project/demo/store/DuckDuckGo-20221213_080436.html)

![DuckDuckGo small](https://kazurayam.github.io/inspectus4katalon-sample-project/images/DuckDuckGo_small.png)

I visited the [DuckDuckGo](https://duckduckgo.com/?) in a browser, typed a keyword `selenium` and hit ENTER to get a list of search results. I took screenshots and saved HTML sources. And finally I made the list of materials.

## Installing and setting up Katalon Studio

Now I would tell you how to make a Katalon Studio project that can produce the same output as shown above. Here I would assume that you have a Windows10 PC with connectivity to the Internet. I would assume have do not have Katalon Studio installed yet. I would assume you do not have any tools including Java SDK installed yet.

### Installing Katalon Studio

You can download the distribution zip file of "Katalon Studio - Standalone Edition" from the following URL.

-   <https://katalon.com/download>

![Katalon Download page](https://kazurayam.github.io/inspectus4katalon-sample-project/images/Katalon-Studio-Free-Download-Katalon.png)

The Standalone Edition is free. You can run the "Visual Inspection" on this free version.

When you click the "Download" button, a dialog will come up to ask you to "Create a Katalon Account" for you personally.

![Sign up Katalon Software Quality Management Platform](https://kazurayam.github.io/inspectus4katalon-sample-project/images/Sign-up-Katalon-Software-Quality-Management-Platform.png)

Just type Full name, Email and Password of your choice. Write a memo of these as you will be asked to type them later again.

You want to download the zip into your local PC, and unzip it. You will get a folder named `Katalon_Studio_Windows_64-x.x.x`. You need to locate it somewhere appropriate on your Windows10 PC. It is required to locate the folder in a ancestor folder which you have a full permission to write. For example, it would be a good idea to locate it to `C:\Users\yourWindowsOSUsername\Katalon_Studio_Windows_64-x.x.x`. But it is not a good idea to locate it inside the `C:\Program Files\` folder, where you might not have sufficient WRITE permission. Also you shouldn’t locate it into the `C:\Users\yourWindowsOSUsername\Documents` folder as the `Documents` folder might be integrated with OneDrive and might be automatically backed up. It’s not a good idea to place large binaries into the OneDrive.

### Launching Katalon Studio

The unzipped folder contains `katalon.exe`. You can launch Katalon Studio by double clicking it.

![katalon.exe](https://kazurayam.github.io/inspectus4katalon-sample-project/images/katalonexe.png)

When you try to launch Katalon Studio for the first time, Windows may show some security advices saying "SmartScan warns you …​" or "you are blocked by Defender firewall…​". You do not mind these too seriouly. Just go on …​

Once you launched Katalon Studio, it will request you to type your Full name, Email, Password that you registered into the Katalon web site. Just do so.

### Configure Katalon Studio

#### Proxy

If your PC is hosted on an organizational private network which is connected to the Internet via Proxy server, you have to configure Katalon Studio to let it know the IP Address of the Proxy etc so that Katalon Studio can communicate with the hosts in the Internet. Refer to the following document:

-   [Set Proxy Preferences in Katalon Studio](https://docs.katalon.com/docs/get-started/set-up-your-workspace/katalon-studio-preferences/set-proxy-preferences-in-katalon-studio)

#### Update WebDriver modules

Katalon Studio runs on top of the [Selenium WebDriver](https://www.selenium.dev/documentation/webdriver/) technology. Katalon Studio talks to the web browsers like Chrome, FireFox via external modules called "WebDriver". There are types of WebDriver for each types of web browsers. Whenever the web browsers are updated, the WebDriver modules will be updated accordingly. Katalon Studio’s distribution zip file bundles a set of WebDriver modules. As you are well aware of, the web browsers are so frequently updated that the bundled versions of WebDriver in the distribution zip inevitably get out of date. Therefore users have to upgrade the WebDriver modules on there own PC for themselves. This is a cumbersome but mandatory task. Katalon Studio offers a GUI menu "Update WebDriver". You can upgrade WebDriver modules easily using this menu. Please refer to the official documentation:

-   [Upgrade or downgrade WebDrivers](https://docs.katalon.com/docs/legacy/katalon-studio-enterprise/test-design/web-test-design/handle-webdrivers/upgrade-or-downgrade-webdrivers)

#### Use Script view, not Manual view, in the Test Case editor

Users will create Groovy scripts, which is categorically called "Test Case" in Katalon term, to implement UI tests. Katalon Studio equips a built-in editor for Test Cases, which has 2 views: Manual view and Script view. In order to implement "Visual Inspection" you need to use Script view rather than Manual view. However Katalon Studio’s initial setup chooses the Manual view as default. You should change the setup and choose the Script view as default.

You want to open "Toolbar Window &gt; Katalon Studio Preferences &gt; Test Case":

![Manual view Script view](https://kazurayam.github.io/inspectus4katalon-sample-project/images/Manual_view_Script_view.png)

### Create a project

Now let’s create a project in "Katalon Studio - Standalone Edition".

File &gt; New &gt; Project

![New Project](https://kazurayam.github.io/inspectus4katalon-sample-project/images/NewProject.png)

A dialog will come up, where you are asked to specify the name of the project, and where to locate it. Of course, you can name it whatever you like, you can place it wherever convenient.

![New Project dialog](https://kazurayam.github.io/inspectus4katalon-sample-project/images/NewProject_dialog.png)

If you typed as above and clicked OK, then a folder `C:\Users\kazurayam\katalon-projects\MyVisualInspectionProject` will be newly created where a set of folders and files are generated by Katalon Studio.

### Setting up the project

There are several setups that I recommend you to follow.

#### Choose type of browser as default

You can choose which type of browser to use when you run ![run](https://kazurayam.github.io/inspectus4katalon-sample-project/images/run_katalon_test.png) your Web UI tests interactively. However, you can specify the default choice in the config.

Project &gt; Settings &gt; Execution

![browser default](https://kazurayam.github.io/inspectus4katalon-sample-project/images/browser_default.png)

In this example, I chose the Chrome Headless as default.

#### No TestOps

Katalon provides a service [TestOps](https://katalon.com/testops), which is not necessary to run Visual Inspection. It may slow down your tests. So you can disable integrating it.

Project &gt; Settings &gt; Katalon TestOps

![TestOps](https://kazurayam.github.io/inspectus4katalon-sample-project/images/TestOps_integration.png)

#### No TestCloud

Katalon provides a service named "TestCloud", which is not necessary to run Visual Inspection. So you can disable integrating it.

Project &gt; Settings &gt; Katalon TestCloud

![TestCloud](https://kazurayam.github.io/inspectus4katalon-sample-project/images/TestCloud_integration.png)

#### Disable Smart Wait

Katalon Studio equips a optional feature named [Smart Wait](https://katalon.com/resources-center/blog/handle-selenium-wait), which sometimes mal-functions. It sometimes slows down a test significantly. Unfortunately Smart Wait is enabled as default. You should disable it.

Project &gt; Settings &gt; Execution &gt; WebUI

![SmartWait](https://kazurayam.github.io/inspectus4katalon-sample-project/images/SmartWait.png)

#### Tune Log Viewer light-weighted

In the right-bottom side there is a pane where you can see logs. There is a tab labeled "Log Viewer".

![Log Viewer](https://kazurayam.github.io/inspectus4katalon-sample-project/images/LogViewer.png)

You should setup Log Viewer appropriately because Katalon Studio emits very verbose execution logs that makes your tests to take long time to finish. See my previous post [Log Viewer slows down your tests](https://forum.katalon.com/t/log-viewer-slows-down-your-tests-how-to-prevent-it/60252).

Firstly, there in the right top of the pane, you can find a toggle button ![tree view](https://kazurayam.github.io/inspectus4katalon-sample-project/images/tree_view.png). If you toggle it on, the Log Viewer displays logs in Tree view. When toggle it off, the Log Viewer displays logs in Table view. You should choose the Table view. The Tree view consumes a lot of CPU and it makes your test slowed down.

In the Table view, you can find a set of buttons labeled All, Info, Passed, Failed, Error, Warning, Not Run. As default, the All button is toggled ON. When the All button is ON, you will see a lot of "START xxxx" and "END xxxx" messages displayed. These messages are just useless. These messages consumes a lot of CPU and makes your test slowed down. You should toggle the All button OFF.

### Creating your first Test Case

Now let’s create a simple Test Case script in your first Katalon Studio project. I made `Test Cases/sample/47news`. It does:

1.  open a web browser

2.  navigate to a URL

3.  wait for a few seconds

4.  close the browser

<!-- -->

    import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

    WebUI.openBrowser('')
    WebUI.navigateToUrl('https://www.47news.jp/')
    WebUI.delay(3)   // stay still for 3 seconds
    WebUI.closeBrowser()

Once you coded this, you can run it by pushing a green arrow button ![run button](https://kazurayam.github.io/inspectus4katalon-sample-project/images/run_katalon_test.png) in the top right of Katalon Studio’s window.

Here is a video which shows how I operated Katalon Studio to run the test.

<https://youtu.be/4jT6pgDmxmc>

&lt;iframe width="560" height="315" src="https://www.youtube.com/embed/4jT6pgDmxmc" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen&gt;&lt;/iframe&gt;

Now you have got Katalon Studio installed, up and running on your Windows PC.

## Setting up Gradle build tool

There is a sample project published on GitHub which implements Visual Inspection.

-   <https://github.com/kazurayam/inspectus4katalon-sample-project>

You can bring the code set and required libraries injected into your own Katalon Studio project. In order to inject the resources, you need to install the build tool Gradle into your Windows PC. Let me explain what needs to be done.

1.  You want to create a new project in Katalon Studio.

2.  You want to utilize a custom Gradle plugin `inpsectus4katalon` which will help you injecting resources from the sample project.

3.  The plugin requires Gradle on your PC. So you need to install Gradle into your PC.

4.  In order to run Gradle, you need Java Runtime Environment installed into your PC.

5.  To install Gradle and Java into your Windows PC, it is a good idea to use the tool [SDKMAN!](https://sdkman.io/). So you want to install SDKMAN! into your Windows PC.

6.  To install SDKMAN!, you need [curl](https://curl.se/) command.

7.  Unfortunately Windows10 does not provide the curl command. Therefore you need to install an environment where the curl command is available. So you want to install [Git for Windows](https://gitforwindows.org/). Once the Git for Windows in installed, you will get a Windows app "Git Bash".

8.  You want to launch "Git Bash", in which you would use curl command to install SDKMAN!. And then using the SDKMAN! you would install Java and Gradle.

9.  Finally, you will create a file `build.gradle` in your Katalon project. You will write just a few lines, and run custom gradle tasks twice. The custom tasks will inject the necessary libraries and sample codes automatically.

That’s the way to go.

### Installing Git for Windows

-   [Git for Windows](https://gitforwindows.org/)

You want to visit this site and click the download button. You will get the installer downloaded. Just execute it. You may choose every options as default. Once installed, you will get the `Git Bash` available.

![Git Bash](https://kazurayam.github.io/inspectus4katalon-sample-project/images/git_bash.png)

### Installing SDKMAN!

Visit the page 　[SDKMAN!](https://sdkman.io/) , then you will find you are suppose to execute the following command in the command line.

    $ curl -s "https://get.sdkman.io" | bash

So you want to open the window of "Git Bash", and in there you want to execute that. You can check if the the SDKMAN! is successfully installed by

    $ sdk version

    SDKMAN 5.xx.xx

See the document [SDKMAN! usage](https://sdkman.io/usage) for the detail of SDKMAN!.

### Installing Java

Now you are ready to install the latest Java using SDKMAN!. Open the window of Gib Bash and type:

    $ sdk install java

This command will install the latest stable version of OpenJDK into your Windows 10. To check you can execute this:

    $ java --verison
    openjdk 17.0.5 2022-10-18
    OpenJDK Runtime Environment Temurin-17.0.5+8 (build 17.0.5+8)
    OpenJDK 64-BIt Server VM Temurin-17.0.5+8 (build 17.0.5+8, mixed mode, sharing)

This message proves that you got the OpenJDK has been successfully installed. Other versions (higher than 8) will be OK to execute Gradle 7.

### Installing Gradle

Let’s go on to install Gradle using SDKMAN! Open the window of Git Bash and execute the following command:

    $ sdk install gradle

This command will install the latest stable version of Gradle. You can check if it works by:

    $ gradle --version

    ----------------------------------------------------------
    Gradle 7.6
    ----------------------------------------------------------
    ...

Now you are ready to use the Gradle build tool on your Windows10.

## Inject the resources required for Visual Inspection into your own Katalon project

You have got Katalon Studio installed, have got Gradle ready to use. Now you are ready to make a Katalon project capable to perform Visual Inspection.

Let me assume that you have created a Katalon Studio project in the folder `C:\Users\yourWindowsOSUsername\katalon-projects\MyVisualInspectionProject`.

In the `MyVisualInspectionProject` folder you would find a file named `build.gradle`. Katalon Studio created it when you newly created the project. However, Katalon Studio does not use the `build.gradle` at all. You can change it or remove it. It does not hurt Katalon Studio at all.

Now you want to edit the `build.gradle` as follows:

    plugins {
      id 'com.kazurayam.inspectus4katalon' version "0.4.0"
    }

This code declares your build wants to use a custom Gradle plugin `com.kazurayam.inspectus4katalon`, which is published at the Gradle Plugin portal [Gradle Plugin Portal](https://plugins.gradle.org/plugin/com.kazurayam.inspectus4katalon).

Now, please stop Katalon Studio. And open the window of Git Bash, change directory into the projects folder:

    $ cd ~/katalon-projects/MyVisualInspectionProject

### gradle deploy-visual-inspection-sample-for-katalon

Now, we will import the sample codes of Visual Inspection into your project. Execute the following in the command line:

    $ gradle deploy-visual-inspection-sample-for-katalon

Then you will see the following messages:

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

What did the `deploy-visual-inspection-sample-for-katalon` task do?

There is a repository named "inspectus4katalon-sample-project" which has the [Releases page](https://github.com/kazurayam/inspectus4katalon-sample-project/releases/tag/0.4.0). There you can find a file `distributable.zip` published and downloadable. In this zip file a full set of sample code of Visual Inspection is contained. The `deploy-visual-inspection-sample-for-katalon` task will download the zip file, unzip it, and overwrites the contents into the current directory. The above messages shows the paths of the files extracted out of the zip.

### gradle drivers task

You want to execute one more Gradle task.

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

When this command finished, you will find in the `Drivers` folder several jar files.

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

These are the jar files required to run the sample code of Visual Inspection. These were not bundled in Katalon Studio, so you needed to add them in the `Drivers` folder. The two jar files [`materialstore`](https://github.com/kazurayam/materialstore) and [`inspectus`](https://github.com/kazurayam/inspectus) are the core part of Visual Inspection implementation. kazurayam has developed them and published as Open Source at the [Maven Central repository](https://mvnrepository.com/artifact/com.kazurayam).

## Let’s run the sample code of Visual Inspection

Now you want to restart Katalon Studio. Open the `MyVisualInspectionProject`. On the left side of the window, you would find `Test Cases` folder. In there you would find folders `CURA`、`DuckDuckGo` and `MyAdmin`. In each of them, there are Test Cases named `main`.

![sample test cases installed](https://kazurayam.github.io/inspectus4katalon-sample-project/images/SampleTestCasesInstalled.png)

Open a `main` Test Case, and run it by clicking the ![green run](https://kazurayam.github.io/inspectus4katalon-sample-project/images/run_katalon_test.png) button. The `main` will take a few seconds to finish. When a `main` finished, a new folder named `store` will be created immediately under the project folder. In the `store` folder, there will be an HTML file `index.html`.

![store/index just created](https://kazurayam.github.io/inspectus4katalon-sample-project/images/store_index_just_created.png)

Unfortunately Katalon Studio has a small bug: the `store` folder will not be visible as soon as it is newly created. So, you have to close the project once, and re-open it. Then the `store` folder will get visible.

Please open `index.html` by double-clicking it. This is exactly what I showed you at the very beginning of this post.

-   [store/index](https://kazurayam.github.io/inspectus4katalon-sample-project/demo/store/index.html)

## Conclusion

I have presented my tool named "Visual Inspection" which enables me to automate verifying the UI of Web applications visually. This post explained how to prepare the environment and how to run the sample code. The custom Gradle plugin `com.kazurayam.inspectus4katalon` enables you to make your own Katalon projects capable of "Visual Inspection" quickly in an automated fashion.

However, you are supposed to develop Katalon Test Cases that interact with your Application Under Test and take screenshots of pages and store the materials into the tailored database named "store". I haven’t covered the programming how-to in this post. It would require a bunch of explanations which would be very long. I would do it in another chance.
