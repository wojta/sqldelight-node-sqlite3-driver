@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")

import kotlin.js.*
import org.khronos.webgl.*
import org.w3c.dom.*
import org.w3c.dom.events.*
import org.w3c.dom.parsing.*
import org.w3c.dom.svg.*
import org.w3c.dom.url.*
import org.w3c.fetch.*
import org.w3c.files.*
import org.w3c.notifications.*
import org.w3c.performance.*
import org.w3c.workers.*
import org.w3c.xhr.*
import NodeJS.Require
import NodeJS.Module
import process.global.NodeJS.Process

external interface NodeRequire : Require

external interface RequireResolve : NodeJS.RequireResolve

external interface NodeModule : Module

@JsModule("node:process")
external val process: Process

@JsModule("node:console")
external val console: Console

external var __filename: String

external var __dirname: String

external var require: NodeRequire

external var module: NodeModule

external var exports: Any

external var gc: (() -> Unit)?

external interface RelativeIndexable<T> {
    fun at(index: Number): T?
}