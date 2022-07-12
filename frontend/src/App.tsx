import HeaderBanner from "./componentes/header"
import SectionSales from "./componentes/SalesSection"

function App() {
    return (
      <>
        <HeaderBanner/>
        <main>
          <section id="sales">
            <div className="dsmeta-container">
              <SectionSales/>
            </div>
          </section>
        </main>

      </>
    )
}

export default App
