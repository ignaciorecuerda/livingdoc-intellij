package info.novatec.testit.livingdoc.intellij.rpc;

import com.intellij.ide.util.PropertiesComponent;
import com.intellij.openapi.project.Project;
import info.novatec.testit.livingdoc.intellij.common.PluginProperties;
import info.novatec.testit.livingdoc.intellij.domain.ProjectSettings;
import info.novatec.testit.livingdoc.server.ServerPropertiesManager;
import org.jetbrains.annotations.NotNull;

/**
 * {@link PropertiesComponent} is used for plugin properties persistence.
 *
 * @see ServerPropertiesManager
 */
class ServerPropertiesManagerImpl implements ServerPropertiesManager {

    private final ProjectSettings projectSettings;
    private final String handler;

    public ServerPropertiesManagerImpl(@NotNull final Project project) {
        projectSettings = ProjectSettings.getInstance(project);
        handler = PluginProperties.getValue("livingdoc.handler.default");
    }

    @Override
    public String getProperty(final String key, final String identifier) {

        String prop;

        switch (key) {

            case ServerPropertiesManager.URL:
                prop = projectSettings.getUrlServer();
                break;

            case ServerPropertiesManager.HANDLER:
                prop = handler;
                break;

            default:
                prop = null;
        }
        return prop;
    }

    @Override
    public void setProperty(final String key, final String value, final String identifier) {
        // properties are read-only
    }
}