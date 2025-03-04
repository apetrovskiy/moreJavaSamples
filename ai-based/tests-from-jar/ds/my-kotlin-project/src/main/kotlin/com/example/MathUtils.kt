package com.example

import org.junit.platform.engine.discovery.DiscoverySelectors
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder
import org.junit.platform.launcher.core.LauncherFactory
import org.junit.platform.launcher.listeners.SummaryGeneratingListener

fun main() {
    val launcher = LauncherFactory.create()
    val listener = SummaryGeneratingListener()

    val request = LauncherDiscoveryRequestBuilder.request()
        .selectors(DiscoverySelectors.selectPackage("com.example"))
        .build()

    launcher.execute(request, listener)

    val summary = listener.summary
    summary.printTo(System.out)
}