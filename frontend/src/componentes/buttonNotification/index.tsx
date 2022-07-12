import NotificationImage from "../../assets/images/icon-notification.svg"
import './style.css'

function NotificationButton() {
    return (
        <div className="dsmeta-red-btn">
            <img src={NotificationImage} alt="Notificar" />
        </div>
    )
}

export default NotificationButton
