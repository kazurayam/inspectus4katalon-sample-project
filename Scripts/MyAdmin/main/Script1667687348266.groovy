import java.nio.file.Path
import java.nio.file.Paths

import com.kazurayam.inspectus.core.Inspectus
import com.kazurayam.inspectus.core.Parameters
import com.kazurayam.inspectus.katalon.KatalonTwinsDiff
import com.kazurayam.materialstore.core.filesystem.JobName
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
SortKeys sortKeys = new SortKeys("step", "URL.host", "URL.path")

Parameters p =
    new Parameters.Builder()
	    .store(store)
		.backup(backup)
		.jobName(jobName)
		.sortKeys(sortKeys)
		.build();

Inspectus inspectus = new KatalonTwinsDiff("Test Cases/MyAdmin/materialize")
inspectus.execute(p)
