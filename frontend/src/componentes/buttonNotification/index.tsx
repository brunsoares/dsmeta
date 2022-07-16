import NotificationImage from "../../assets/images/icon-notification.svg";
import axios from 'axios';
import { BASE_URL } from '../../utils/request';
import './style.css';
import { toast } from "react-toastify";

type Props={
    saleId: number;
}

function handleClick(id: number){
    axios.get(`${BASE_URL}/sales/${id}/notification`)
         .then(response => {
            toast.info("SMS enviado com sucesso!")
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
