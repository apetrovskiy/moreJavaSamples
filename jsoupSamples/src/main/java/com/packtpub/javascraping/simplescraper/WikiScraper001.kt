package com.packtpub.javascraping.simplescraper

import org.jsoup.Jsoup
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.MalformedURLException
import java.net.URL
import java.net.URLConnection

class WikiScraper001 {
    fun scrapeTopic(url: String) {
        val html = getUrl("https://www.wikipedia.org$url")
        val doc = Jsoup.parse(html)
        val contentText = doc.select("#mw-content-text").first().text()
        println(contentText)
    }

    private fun getUrl(url: String): String {
        var urlObj: URL? = null
        try {
            urlObj = URL(url)
        }
        catch (e: MalformedURLException) {
            println("The url was malformed")
            return ""
        }
        var urlCon: URLConnection? = null
        var in1: BufferedReader? = null
        var outputText = ""
        try {
            urlCon = urlObj.openConnection()
            in1 = BufferedReader(InputStreamReader(urlCon.getInputStream()))
            var line = in1.readLine()
            while (null != line) {
                outputText += line
                line = in1.readLine()
            }
            in1.close()
        }
        catch (e: IOException) {
            println("There was an error connecting to the URL")
            return ""
        }
        return outputText
    }
}

fun main() {
    val scraper = WikiScraper001()
    scraper.scrapeTopic("/wiki/Python")
}
