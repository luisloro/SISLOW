import {Route,Routes,Link} from "react-router-dom";
import CadProduto from "../cad.produto";
import {useForm} from  'react-hook-form';
import axios from 'axios';
import { BASE_URL } from "../request";
import { useEffect, useState } from "react";
import { Cliente } from "../models/cliente";


function CadCliente(){

    const {register, handleSubmit} = useForm();


    const [lista,setLista] = useState<Cliente[]>([]);

    const [nomeCliente,setNome] = useState('');
    const [foneCliente,setFone] = useState('');
    const [cpfCliente,setCPF] = useState('');


    const cadCliente = (dados: any)=> axios.post(
        `${BASE_URL}/cadcliente?nome=${nomeCliente}&fone=${foneCliente}&cpf=${cpfCliente}`).then(response => {
            console.log(response.data);
        });
    return(
        
            
            <div>
                <form onSubmit={handleSubmit(cadCliente)} >
                    <label >Nome do Cliente</label>
                    <input type="text" value={nomeCliente} onChange={(e)=>setNome(e.target.value)}/>

                    <label >Fone</label>
                    <input type="text" value={foneCliente} onChange={(e)=>setFone(e.target.value)}/>

                    <label >CPF</label>
                    <input type="text" value={cpfCliente} onChange={(e)=>setCPF(e.target.value)} />

                    

                    <button type="submit">Enviar</button>
                </form>

                <table>
                    <thead>
                    <tr>
                            <th>Teste</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            lista.map(cliente=>{
                                return(
                            <tr key={cliente.id}>
                            <td>{cliente.nome}</td>
                            <td>teste</td>
                            <td><Link to={`/editcli/${cliente.id}`}> Edita Cliente </Link></td>
                        </tr>
                                )
                            })
                        }
                    
                    
                    </tbody>
                        
                </table>
            </div>

            
        

    )
}

export default CadCliente;

