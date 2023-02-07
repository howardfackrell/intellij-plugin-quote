package org.jetbrains.plugins.template

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.command.WriteCommandAction
import com.intellij.openapi.ui.popup.JBPopupFactory
import com.intellij.ui.components.JBTextArea
import java.awt.Dimension


class OctRetrieveServiceTokenAction() : AnAction("OctRetrieveServiceTokenAction") {
    //    val octGraphqlService = service<OctGraphqlService>()
    override fun actionPerformed(e: AnActionEvent) {

        println("Running the client token action")
        val runnable: Runnable = Runnable {

//            val serviceToken = octGraphqlService.retrieveServiceToken()

            var textArea = JBTextArea()
            textArea.text = "just kidding"
            textArea.preferredSize = Dimension(400, 400)
            textArea.isEditable = true
            JBPopupFactory.getInstance().createComponentPopupBuilder(textArea, textArea).createPopup()
                .showInBestPositionFor(e.dataContext)
        }
        WriteCommandAction.runWriteCommandAction(e.project, runnable)
    }
}