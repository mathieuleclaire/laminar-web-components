import com.raquo.laminar.api.L._
import org.scalajs.dom.document

import dev.laminar.material._

object App {

  def main(args: Array[String]): Unit = {
    val appElement = TopAppBarFixed(
      _.slots.title(span("Laminar Web Components Showcase")),
      _.slots.default(
        TabBar(
          _.slots.default(
            TabBar.Tab(
              _.label := "Tab 1",
            ),
            TabBar.Tab(
              _.label := "Tab 2",
            ),
          ),
        ),
        p(
          Button(
            _.label := "Button",
          ),
        ),
        p(
          Textfield(
            _.label := "Text field",
          ),
        ),
        p(
          List(
            _.activatable := true,
            _.slots.default(
              List.ListItem(_.slots.default(span("List Item 1"))),
              List.ListItem(_.slots.default(span("List Item 2"))),
            ),
          ),
        ),
      ),
    )

    documentEvents.onDomContentLoaded.foreach { _ =>
      render(document.body, appElement)
    }(unsafeWindowOwner)
  }
}
