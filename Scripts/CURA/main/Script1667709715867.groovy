import java.nio.file.Path
import java.nio.file.Paths

import com.kazurayam.inspectus.core.Inspectus
import com.kazurayam.inspectus.core.Parameters
import com.kazurayam.inspectus.katalon.KatalonChronosDiff
import com.kazurayam.materialstore.core.filesystem.JobName
import com.kazurayam.materialstore.core.filesystem.JobTimestamp
import com.kazurayam.materialstore.core.filesystem.SortKeys
import com.kazurayam.materialstore.core.filesystem.Store
import com.kazurayam.materialstore.core.filesystem.Stores
import com.kms.katalon.core.configuration.RunConfiguration

/**
 * Test Cases/CURA/main
 *
 */
Path projectDir = Paths.get(RunConfiguration.getProjectDir())
Path local = projectDir.resolve("store")
Path remote = projectDir.resolve("store-backup")
Store store = Stores.newInstance(local)
Store backup = Stores.newInstance(remote)
JobName jobName = new JobName("CURA")
JobTimestamp jobTimestamp = JobTimestamp.now()
SortKeys sortKeys = new SortKeys("step", "profile", "URL.host", "URL.path", "URL.fragment")

Parameters p =
	new Parameters.Builder()
		.store(store)
		.backup(backup)
		.jobName(jobName)
		.jobTimestamp(jobTimestamp)
		.sortKeys(sortKeys)
		.build();

Inspectus inspectus = new KatalonChronosDiff("Test Cases/CURA/materialize")
inspectus.execute(p)
