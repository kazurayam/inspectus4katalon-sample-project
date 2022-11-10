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


Map<String, Object> intermediates = new LinkedHashMap<>();

String profileLeft = "MyAdmin_ProductionEnv"
JobTimestamp jtLeft = callProcessEnv(profileLeft)
intermediates.put(Intermediates.KEY_profileLeft, profileLeft)
intermediates.put(Intermediates.KEY_jobTimestampLeft, jtLeft)

String profileRight = "MyAdmin_DevelopmentEnv" 
JobTimestamp jtRight = callProcessEnv(profileRight)
intermediates.put(Intermediates.KEY_profileRight, profileRight)
intermediates.put(Intermediates.KEY_jobTimestampRight, jtRight)

return intermediates


/*
 * 
 */
JobTimestamp callProcessEnv(String profile) {
	Path projectDir = Paths.get(RunConfiguration.getProjectDir())
	// utility class that loads specified Execution Profiles intentionally
	ExecutionProfilesLoader profilesLoader = new ExecutionProfilesLoader()
	profilesLoader.loadProfile(profile)
	Path targetFile = projectDir.resolve(GlobalVariable.CSV)
	JobTimestamp jobTimestamp = JobTimestamp.now()
	// utility class to parse CSV file
	TargetCSVParser parser = TargetCSVParser.newSimpleParser();
	List<Target> targetList = parser.parse(targetFile)
									.stream()
									.map({target -> target.copyWith(["profile": profile])})
									.collect(Collectors.toList())
	WebUI.callTestCase(findTestCase("Test Cases/MyAdmin/processEnv"),
						[
							"store": store,
							"jobName": jobName,
							"jobTimestamp": jobTimestamp,
							"targetList": targetList
						])

	return jobTimestamp;
}

