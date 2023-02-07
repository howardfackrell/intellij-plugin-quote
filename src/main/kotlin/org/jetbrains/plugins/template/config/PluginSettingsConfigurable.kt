package org.jetbrains.plugins.template.config

import com.intellij.openapi.components.service
import com.intellij.openapi.options.Configurable
import org.jetbrains.plugins.template.services.OctGraphqlService
import javax.swing.JComponent

class PluginSettingsConfigurable : Configurable {
    private val pluginSettingsComponent = PluginSettingsComponent()
    private val octGraphqlService = service<OctGraphqlService>()

    override fun createComponent(): JComponent? {
        return pluginSettingsComponent.panel
    }

    override fun isModified(): Boolean {
        val persistentState = octGraphqlService.persistentState
        val modified = !persistentState?.tokenUrl.equals(pluginSettingsComponent.tokenUrl).or(true)
                || !persistentState?.graphUrl.equals(pluginSettingsComponent.graphUrl).or(true)
                || !persistentState?.clientId.equals(pluginSettingsComponent.clientId).or(true)
                || !persistentState?.clientSecret.equals(pluginSettingsComponent.clientSecret).or(true)
        return modified
    }

    override fun apply() {
        val persistentState = octGraphqlService.persistentState
        persistentState?.tokenUrl = pluginSettingsComponent.tokenUrl
        persistentState?.graphUrl = pluginSettingsComponent.graphUrl
        persistentState?.clientId = pluginSettingsComponent.clientId
        persistentState?.clientSecret = pluginSettingsComponent.clientSecret
    }

    override fun reset() {
        val persistentState = octGraphqlService.persistentState
        pluginSettingsComponent.tokenUrl = persistentState?.tokenUrl?: "token url"
        pluginSettingsComponent.graphUrl = persistentState?.graphUrl?: "graph url"
        pluginSettingsComponent.clientId = persistentState?.clientId?: "id"
        pluginSettingsComponent.clientSecret = persistentState?.clientSecret?: "secret"
    }

    override fun getDisplayName(): String {
        return "OCT GraphQL"
    }
}