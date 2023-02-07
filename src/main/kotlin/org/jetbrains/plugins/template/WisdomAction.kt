package org.jetbrains.plugins.template

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.command.WriteCommandAction


class WisdomAction() : AnAction("Wisdom Action") {
    override fun actionPerformed(e: AnActionEvent) {

        println("Running the Wisdom Action")
        val offset : Int? = e.getData(CommonDataKeys.CARET)?.offset
        val document = e.dataContext
                .getData(CommonDataKeys.EDITOR)
                ?.document

        val runnable: Runnable = Runnable {
            offset.let {
                document?.insertString(it!!, "Here is wisdom")
            }
        }
        WriteCommandAction.runWriteCommandAction(e.project, runnable)
    }
}