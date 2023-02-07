package org.jetbrains.plugins.template

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.command.WriteCommandAction
import com.intellij.openapi.ui.popup.JBPopupFactory
import com.intellij.ui.components.JBTextArea
import java.awt.Dimension


class PopupWisdomAction() : AnAction("Popup Wisdom Action") {
    override fun actionPerformed(e: AnActionEvent) {

        println("Running the Popup Wisdom Action")
        val runnable: Runnable = Runnable {
            var textArea = JBTextArea()
            textArea.text = "Wisdom in a popup"
            textArea.preferredSize = Dimension(400, 400)
            textArea.isEditable = true
            JBPopupFactory.getInstance().createComponentPopupBuilder(textArea, textArea).createPopup()
                .showInBestPositionFor(e.dataContext)
        }
        WriteCommandAction.runWriteCommandAction(e.project, runnable)
    }
}