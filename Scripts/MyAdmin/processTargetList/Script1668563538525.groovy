import java.nio.file.Files

import org.openqa.selenium.WebDriver

import com.kazurayam.materialstore.base.materialize.MaterializingPageFunctions
import com.kazurayam.materialstore.base.materialize.StorageDirectory
import com.kazurayam.materialstore.base.materialize.Target
import com.kazurayam.materialstore.core.filesystem.Material
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

Objects.requireNonNull(store)
Objects.requireNonNull(jobName)
Objects.requireNonNull(jobTimestamp)
Objects.requireNonNull(targetList)

WebUI.openBrowser('')
WebUI.setViewPortSize(1024, 800)

WebDriver driver = DriverFactory.getWebDriver()
StorageDirectory sd = new StorageDirectory(store, jobName, jobTimestamp)

for (Target target in targetList) {
	
	WebUI.navigateToUrl(target.getUrl().toExternalForm())
	
	// take and store the entire screenshot using AShot
	Material screenshot =
		MaterializingPageFunctions.storeEntirePageScreenshot.accept(target, driver, sd)
	assert Files.exists(screenshot.toPath(store))
	
	// take and store the HTML source
	Material html =
		MaterializingPageFunctions.storeHTMLSource.accept(target, driver, sd)
	assert Files.exists(html.toPath(store))
}

WebUI.closeBrowser()