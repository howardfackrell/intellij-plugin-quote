package org.jetbrains.plugins.template.config

import com.intellij.ui.components.JBTextField
import com.intellij.util.ui.FormBuilder
import javax.swing.JPanel

class PluginSettingsComponent {
    private var tokenUrlText = JBTextField();
    private var graphUrlText = JBTextField();
    private var clientIdText = JBTextField();
    private var clientSecretText = JBTextField();
    val panel: JPanel = FormBuilder.createFormBuilder()
        .addLabeledComponent("Core Auth Token URL: ", tokenUrlText)
        .addLabeledComponent("GraphQL URL: ", graphUrlText)
        .addLabeledComponent("Client ID: ", clientIdText)
        .addLabeledComponent("Client Secret: ", clientSecretText)
        .addComponentFillVertically(JPanel(), 0)
        .panel

    var tokenUrl: String
        get() = tokenUrlText.text
        set(url: String) {
            tokenUrlText.text = url
        }

    var graphUrl: String
        get() = graphUrlText.text
        set(url: String) {
            graphUrlText.text = url
        }

    var clientId: String
        get() = clientIdText.text
        set(id: String) {
            clientIdText.text = id
        }

    var clientSecret: String
        get() = clientSecretText.text
        set(secret: String) {
            clientSecretText.text = secret
        }
}