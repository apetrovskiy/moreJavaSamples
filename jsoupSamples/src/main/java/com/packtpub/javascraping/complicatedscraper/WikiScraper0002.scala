package com.packtpub.javascraping.complicatedscraper

import java.io.{BufferedReader, IOException, InputStreamReader}
import java.net.{MalformedURLException, URL, URLConnection}
import org.jsoup.Jsoup
import scala.util.Random

object WikiScraper0002 {
  private var generator: Random = null
  def main(args: Array[String]) = {
    generator = new Random(31415926)
    scrapeTopic("/wiki/Java")
  }
  def scrapeTopic(url: String): Unit = {
    val html = getUrl(s"https://www.wikipedia.org${url}")
    val doc = Jsoup.parse(html)
    val links = doc.select("#mw-content-text [href~=^/wiki/((?!:).)*$]")
    if (links.isEmpty) {
      println(s"No links found at ${url}. Going back to Java!")
      scrapeTopic("wiki/Java")
    }
    val r = generator.nextInt(links.size())
    println(s"Random link is: ${links.get(r).text()} at url: ${links.get(r).attr("href")}")
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
      var line = in.readLine()
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
