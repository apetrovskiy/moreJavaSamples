package com.packtpub.javascraping.complicatedscraper

import org.jsoup.Jsoup
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.MalformedURLException
import java.net.URL
import java.net.URLConnection
import kotlin.random.Random

class WikiScraper0001 {
    private var generator: Random = Random(31415926)
    fun scrapeTopic(url: String) {
        val html = getUrl("https://www.wikipedia.org$url")
        val doc = Jsoup.parse(html)
        val links = doc.select("#mw-content-text [href~=^/wiki/((?!:).)*$]")
        if (!links.any()) {
            println("No links found at $url. Going back to Java!")
            scrapeTopic("wiki/Java")
        }
        val r = generator.nextInt(links.size)
        println("Random link is: ${links[r].text()} at url: ${links[r].attr("href")}")
        scrapeTopic(links[r].attr("href"))

    }
    fun getUrl(url: String): String {
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

fun main(args: Array<String>) {
    val scraper = WikiScraper0001()
    scraper.scrapeTopic("/wiki/Java")
}
