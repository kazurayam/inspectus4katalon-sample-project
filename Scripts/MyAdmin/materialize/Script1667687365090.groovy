import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase

import java.nio.file.Path
import java.nio.file.Paths
import java.util.stream.Collectors

import com.kazurayam.inspectus.core.Intermediates
import com.kazurayam.ks.globalvariable.ExecutionProfilesLoader
import com.kazurayam.materialstore.base.materialize.Target
import com.kazurayam.materialstore.base.materialize.TargetCSVParser
import com.kazurayam.materialstore.core.filesystem.JobTimestamp
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

/**
 * Test Cases/main/MyAdmin/materialize
 *
 */
// check params which should be passed as the arguments of WebUI.callTestCases() call
Objects.requireNonNull(store)
Objects.requireNonNull(jobName)
Objects.requireNonNull(jobTimestamp)
Objects.requireNonNull(environment)

String executionProfile = environment.toString()

List<Target> targetList = getTargetList(executionProfile)

WebUI.callTestCase(findTestCase("Test Cases/MyAdmin/processTargetList"),
						[
							"store": store,
							"jobName": jobName,
							"jobTimestamp": jobTimestamp,
							"targetList": targetList
						])

/**
 * look at the Execution Profile to find a CSV file 
 * where list of multiple target URLs are written  
 */
List<Target> getTargetList(String executionProfile) {
	
	// utility class that loads specified Execution Profiles to make the GlobalVariable.CSV accessible
	ExecutionProfilesLoader profilesLoader = new ExecutionProfilesLoader()
	profilesLoader.loadProfile(executionProfile)
	
	// identify the target CSV file
	Path targetFile = Paths.get(RunConfiguration.getProjectDir()).resolve(GlobalVariable.CSV)
	
	// utility class to parse a CSV file to generate a List<Target>
	TargetCSVParser parser = TargetCSVParser.newSimpleParser();

	List<Target> targetList = 
		parser.parse(targetFile).stream()
				// creates a new instance of Target class while adding an "environment" attribute
				.map({target -> target.copyWith(["environment": executionProfile])})
				.collect(Collectors.toList())

	return targetList
}
