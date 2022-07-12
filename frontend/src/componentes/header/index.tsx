import BannerDesktop from "../../assets/images/logo-desktop.svg";
import './style.css';

function HeaderApp() {
    return (
        <header>
            <div className="dsmeta-logo-container">
                <img src={BannerDesktop} alt="DSMeta" />
                <h1>DSMeta</h1>
                <p>
                    Desenvolvido por 
                    <a href="https://github.com/brunsoares"> @brunsoares</a>
                </p>
            </div>
        </header>
    )
}

export default HeaderApp;
