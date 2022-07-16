import HeaderBanner from "./componentes/header";
import SectionSales from "./componentes/SalesSection";
import { ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

function App() {
    return (
      <>
        <ToastContainer/>
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

export default App;
