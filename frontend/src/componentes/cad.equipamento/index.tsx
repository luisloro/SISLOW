<<<<<<< HEAD
import { Route, Routes, Link } from "react-router-dom";
import CadProduto from ".";
import { useForm } from 'react-hook-form';
=======
import {Route,Routes,Link} from "react-router-dom";
import CadProduto from ".";
import {useForm} from  'react-hook-form';
>>>>>>> ee6cfc2ec7a18d0f1eb2ac32e7594751812b81e6
import axios from 'axios';
import { BASE_URL } from "../request";
import { useEffect, useState } from "react";
import { Cliente } from "../models/cliente";


<<<<<<< HEAD
function CadEquipamento() {

    const { register, handleSubmit } = useForm();

    const [modelo, setModelo] = useState('');
    const [marca, setMarca] = useState('');
    const [tipo, setTipo] = useState('');
    const [serial, setSerial] = useState('');
    const [error, setError] = useState('');


    const cadEquipamento = (dados: any) => axios.post(
        `${BASE_URL}/api/v2/equipamento`,
        {
            "modelo" : modelo,
            "marca" : marca,
            "tipo" : tipo,
            "emprestado" : false,
            "serial": serial
        }).then(response => {
=======
function CadEquipamento(){

    const {register, handleSubmit} = useForm();



    const [modelo,setModelo] = useState('');
    const [marca,setMarca] = useState('');
    const [tipo,setTipo] = useState('');
    const [serial,setSerial] = useState('');


    const cadEquipamento = (dados: any)=> axios.post(
        `${BASE_URL}/cadequip?modelo=${modelo}&marca=${marca}&tipo=${tipo}&serial=${serial}`).then(response => {
            console.log(response.data);
>>>>>>> ee6cfc2ec7a18d0f1eb2ac32e7594751812b81e6
            setModelo('');
            setMarca('');
            setTipo('');
            setSerial('');
<<<<<<< HEAD
            setError('');
        }).catch(error => {
            console.log(error);
            setError(error.response.data)
        });

    return (
        <div>
            {error ? <div className="alert alert-danger">
                {error}
            </div> : null}
            
            <form onSubmit={handleSubmit(cadEquipamento)} >
                <div className="row">
                    <div className="col-md-4">
                        <label >Marca do Equipamento:</label>
                        <input className="form-control" type="text" value={marca} onChange={(e) => setMarca(e.target.value)} />
                    </div>
                    <div className="col-md-4">
                        <label >Modelo do Equipamento:</label>
                        <input className="form-control" type="text" value={modelo} onChange={(e) => setModelo(e.target.value)} />
                    </div>
                </div>
                <div className="row">
                    <div className="col-md-4">
                        <label >Tipo do Equipamento:</label>
                        <input className="form-control" type="text" value={tipo} onChange={(e) => setTipo(e.target.value)} />
                    </div>
                    <div className="col-md-4">
                        <label >Serial do Equipamento:</label>
                        <input className="form-control" type="text" value={serial} onChange={(e) => setSerial(e.target.value)} />
                    </div>
                </div>
                <div className="row">
                    <div className="col-md-4">
                        <button className="btn btn-success min-300 mt-3" type="submit">Enviar</button>
                    </div>
                </div>
            </form>
        </div>
=======
        });
    return(
        
            
            <div>
                <form onSubmit={handleSubmit(cadEquipamento)} >
                    <label >Marca do Equipamento</label>
                    <input type="text" value={marca} onChange={(e)=>setMarca(e.target.value)}/>

                    <label >Modelo do Equipamento</label>
                    <input type="text" value={modelo} onChange={(e)=>setModelo(e.target.value)}/>

                    <label >Tipo do Equipamento</label>
                    <input type="text" value={tipo} onChange={(e)=>setTipo(e.target.value)} />

                    <label >Serial do Equipamento</label>
                    <input type="text" value={serial} onChange={(e)=>setSerial(e.target.value)} />

                    

                    <button type="submit">Enviar</button>
                </form>


                        
        
            </div>

            
        

>>>>>>> ee6cfc2ec7a18d0f1eb2ac32e7594751812b81e6
    )
}

export default CadEquipamento;
<<<<<<< HEAD
=======

>>>>>>> ee6cfc2ec7a18d0f1eb2ac32e7594751812b81e6