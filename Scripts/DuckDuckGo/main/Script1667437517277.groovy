import java.nio.file.Path
import java.nio.file.Paths

import com.kazurayam.inspectus.core.Inspectus
import com.kazurayam.inspectus.core.Parameters
import com.kazurayam.inspectus.katalon.KatalonShootings
import com.kazurayam.materialstore.core.filesystem.JobName
import com.kazurayam.materialstore.core.filesystem.JobTimestamp
import com.kazurayam.materialstore.core.filesystem.SortKeys
import com.kazurayam.materialstore.core.filesystem.Store
import com.kazurayam.materialstore.core.filesystem.Stores
import com.kms.katalon.core.configuration.RunConfiguration

/**
 * Test Cases/DuckDuckGo/main
 */
Path projectDir = Paths.get(RunConfiguration.getProjectDir())
Store store = Stores.newInstance(projectDir.resolve("store"));
Store backup = Stores.newInstance(projectDir.resolve("store-backup"))
JobName jobName = new JobName("DuckDuckGo")
JobTimestamp jobTimestamp = JobTimestamp.now()
SortKeys sortKeys = new SortKeys("step", "URL.host", "URL.path")

Parameters p = 
	new Parameters.Builder()
		.store(store)
		.backup(backup)
		.jobName(jobName)
		.jobTimestamp(jobTimestamp)
		.sortKeys(sortKeys)
		.build();

Inspectus inspectus = new KatalonShootings("Test Cases/DuckDuckGo/materialize")
inspectus.execute(p);

