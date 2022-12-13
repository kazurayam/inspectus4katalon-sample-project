import java.nio.file.Path
import java.nio.file.Paths

import com.kazurayam.inspectus.core.Environment
import com.kazurayam.inspectus.core.Inspectus
import com.kazurayam.inspectus.core.Parameters
import com.kazurayam.inspectus.katalon.KatalonTwinsDiff
import com.kazurayam.materialstore.core.filesystem.JobName
import com.kazurayam.materialstore.core.filesystem.JobTimestamp
import com.kazurayam.materialstore.core.filesystem.SortKeys
import com.kazurayam.materialstore.core.filesystem.Store
import com.kazurayam.materialstore.core.filesystem.Stores
import com.kms.katalon.core.configuration.RunConfiguration

/**
 * Test Cases/MyAdmin/main
 *
 */
Path projectDir = Paths.get(RunConfiguration.getProjectDir())
Path local = projectDir.resolve("store")
Path remote = projectDir.resolve("store-backup")
Store store = Stores.newInstance(local)
Store backup = Stores.newInstance(remote)
JobName jobName = new JobName("MyAdmin")
JobTimestamp jobTimestamp = JobTimestamp.now()
SortKeys sortKeys = new SortKeys("step", "URL.host", "URL.path")

Parameters p =
    new Parameters.Builder()
	    .store(store)
		.backup(backup)
		.jobName(jobName)
		.jobTimestamp(jobTimestamp)
		.sortKeys(sortKeys)
		.threshold(3.0)    // ignore differences less than 3.0%
		.build();

Inspectus inspectus =
	new KatalonTwinsDiff("Test Cases/MyAdmin/materialize",
						new Environment("MyAdmin_ProductionEnv"),
						new Environment("MyAdmin_DevelopmentEnv"))
inspectus.execute(p)
