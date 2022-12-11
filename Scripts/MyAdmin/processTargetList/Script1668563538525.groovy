import java.nio.file.Files

import org.openqa.selenium.WebDriver

import com.kazurayam.inspectus.materialize.selenium.WebPageMaterializingFunctions
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

targetList.eachWithIndex { target, index ->
	
	WebUI.navigateToUrl(target.getUrl().toExternalForm())
	
	// take and store the entire screenshot using AShot
	WebPageMaterializingFunctions pmf = new WebPageMaterializingFunctions(store, jobName, jobTimestamp)
	Map<String, String> attributes = ["step": String.format("%02d", index + 1)]
	
	Material screenshot = pmf.storeEntirePageScreenshot.accept(driver, target, attributes)
	assert Files.exists(screenshot.toPath(store))
	
	// take and store the HTML source
	Material html = pmf.storeHTMLSource.accept(driver, target, attributes)
	assert Files.exists(html.toPath(store))
}

WebUI.closeBrowser()