import NotificationImage from "../../assets/images/icon-notification.svg";
import axios from 'axios';
import { BASE_URL } from '../../utils/request';
import './style.css';

type Props={
    saleId: number;
}

function handleClick(id: number){
    axios.get(`${BASE_URL}/sales/${id}/notification`)
         .then(response => {
            console.log("Notificação enviada!")
         });
}

function NotificationButton({saleId} : Props) {
    return (
        <div className="dsmeta-red-btn" onClick={() => handleClick(saleId)}>
            <img src={NotificationImage} alt="Notificar" />
        </div>
    )
}

export default NotificationButton;
