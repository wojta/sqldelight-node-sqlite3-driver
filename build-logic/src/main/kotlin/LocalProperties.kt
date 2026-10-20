import org.gradle.api.Project
import java.util.Properties

/**
 * Value from `local.properties` in the root project, `null` when the file or the key is missing.
 */
fun Project.localProperty(key: String): String? {
    val file = rootProject.file("local.properties")
    if (!file.exists()) return null
    return Properties().apply { file.inputStream().use(::load) }.getProperty(key)
}
