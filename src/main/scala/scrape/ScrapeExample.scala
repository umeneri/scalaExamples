package scrape

import net.ruippeixotog.scalascraper.browser.{Browser, JsoupBrowser}
import net.ruippeixotog.scalascraper.dsl.DSL.Extract._
import net.ruippeixotog.scalascraper.dsl.DSL._
import net.ruippeixotog.scalascraper.model.Document

object ScrapeExample {
  def main(args: Array[String]): Unit = {
    val url = "http://konbu13.hatenablog.com/"
    val browser = JsoupBrowser()

    val titles = crawl(url, browser, 2)
    println(titles)
  }

  def crawl(url: String, browser: Browser, count: Int): Seq[String] = count match {
    case 0 => Seq.empty
    case _ =>
      println(s"process url: $url count: $count")

      Thread.sleep(300)

      val doc: browser.DocumentType = browser.get(url)
      val titles = getTitles(doc).getOrElse(Nil)
      val links = getLinks(doc).getOrElse(Nil)

      println(s"titles: $titles")

      titles ++ links.flatMap(crawl(_, browser, count - 1))
  }

  private def getLinks(doc: Document): Option[Seq[String]] = {
    val tagItemsOpt = doc >?> elementList("#box2-inner > div.hatena-module.hatena-module-category > div.hatena-module-body > ul.hatena-urllist li a")
    tagItemsOpt.map(tagItems => tagItems.map(_.attr("href")))
  }

  private def getTitles(doc: Document): Option[Seq[String]] = {
    val titlesOpt = doc >?> elementList("h1.entry-title")
    titlesOpt.map(titles => titles.map(_.text))
  }
}
