package com.packtpub.javascraping.simplescraper

import java.io.{BufferedReader, InputStreamReader, IOException}
import java.net.{MalformedURLException, URL, URLConnection}

import org.jsoup.Jsoup

object WikiScraper002 {
  def main(args: Array[String]): Unit = {
    scrapeTopic("/wiki/Python")
  }

  def scrapeTopic(url: String) = {
    // val html = getUrl(s"https://www.wikipedia.org/${url}")
    val html = getUrl("https://www.wikipedia.org" + url)
    val doc = Jsoup.parse(html)
    val contentText = doc.select("#mw-content-text").first().text()
    println(contentText)
  }

  def getUrl(url: String): String = {
    var urlObj: URL = null
    try {
      urlObj = new URL(url)
    }
    catch {
      case e: MalformedURLException => {
        println("The url was malformed")
        return ""
      }
    }
    var urlCon: URLConnection = null
    var in: BufferedReader = null
    var outputText = ""
    try {
      urlCon = urlObj.openConnection()
      in = new BufferedReader(new InputStreamReader(urlCon.getInputStream))
      var line = ""
      while (null != line) {
        outputText += line
        line = in.readLine()
      }
      in.close()
    }
    catch {
      case e: IOException => {
        println("There was an error connecting to the URL")
        return ""
      }
    }
    return outputText
  }
}
