package com.github.howardfackrell.intellijpluginquote.services

import com.github.howardfackrell.intellijpluginquote.MyBundle
import com.intellij.openapi.project.Project

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
