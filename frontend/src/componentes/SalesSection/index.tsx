import NotificationButton from '../buttonNotification';
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";
import './style.css';
import { useEffect, useState } from 'react';
import axios from 'axios';
import { BASE_URL } from '../../utils/request';
import { Sale } from '../../models/sales';

function SectionSales() {
    const dataUmAnoAntes = new Date(new Date().setDate(new Date().getDate() - 365));
    const dataAtual = new Date();

    const [dataMinima, setDataMinima] = useState(dataUmAnoAntes);   // Constante com valor padrão de hoje
    const [dataMaxima, setDataMaxima] = useState(dataAtual);
    
    const [sales, setSales] = useState<Sale[]>([]);                 // Constante com valor das vendas pelo backend 

    // Usado juntamente com AXIOS
    useEffect(() => {
        axios.get(`${BASE_URL}/sales`)
             .then(response => {
                setSales(response.data.content);
             });
    }, []);

    return (
        <div className="dsmeta-card">
            <h2 className="dsmeta-sales-title">Vendas</h2>
            <div>
                <div className="dsmeta-form-control-container">
                    <p className="dsmeta-paragrafo-left">Data Inicial</p>
                    <DatePicker
                        selected={dataMinima}
                        onChange={(date: Date) => setDataMinima(date)}
                        className="dsmeta-form-control"
                        dateFormat="dd/MM/yyyy"
                    />

                </div>
                <div className="dsmeta-form-control-container">
                    <p className="dsmeta-paragrafo-left">Data Final</p>
                    <DatePicker
                        selected={dataMaxima}
                        onChange={(date: Date) => setDataMaxima(date)}
                        className="dsmeta-form-control"
                        dateFormat="dd/MM/yyyy"
                    />
                </div>
            </div>

            <div>
                <table className="dsmeta-sales-table">
                    <thead>
                        <tr>
                            <th className="show992">ID</th>
                            <th className="show576">Data</th>
                            <th>Vendedor</th>
                            <th className="show992">Visitas</th>
                            <th className="show992">Vendas</th>
                            <th>Total</th>
                            <th>Notificar</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            sales.map(sale => {
                                return (
                                <tr key={sale.id}>
                                    <td className="show992">{sale.id}</td>
                                    <td className="show576">{new Date(sale.date).toLocaleDateString()}</td>
                                    <td>{sale.sellerName}</td>
                                    <td className="show992">{sale.visited}</td>
                                    <td className="show992">{sale.deals}</td>
                                    <td>R${sale.amount.toFixed(2)}</td>
                                    <td>
                                        <div className="dsmeta-red-btn-container">
                                            <NotificationButton />
                                        </div>
                                    </td>
                                </tr> 
                                )
                            })
                        }
                    </tbody>
                </table>
            </div>
        </div>
    )
}

export default SectionSales;
