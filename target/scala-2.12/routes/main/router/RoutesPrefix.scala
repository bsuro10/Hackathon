// @GENERATOR:play-routes-compiler
// @SOURCE:G:/Websites Projects/Hackathon/conf/routes
// @DATE:Sat Mar 03 17:06:29 IST 2018


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
