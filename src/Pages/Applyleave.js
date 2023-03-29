
import { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import Employeedropdown from './Employeedropdown';
import { isExpired } from 'react-jwt';
import "react-datepicker/dist/react-datepicker.css";
function Applyleave() {
    const navigate = useNavigate();
    const [leave, setLeave] = useState(
        {

            emailId: "",
            memailId: "",
            fromDate: "",
            toDate: "",
            leaveReason: "",
        }
    )
    const[isFormValid,setIsFormValid]=useState(false);
    const[errors,setErrors]=useState({});
    const validateForm =()=>{
        const errors={};
        if(!emailId){
            errors.emailId='Email is required';
        }
        else if (!/\S+@\S+\.\S+/.test(emailId)) {
            errors.emailId = 'Email is invalid';
       }
        if(!fromDate){
            errors.fromDate='fromDate is required';
        }
        if(!toDate){
            errors.toDate='toDate is required';
        }
       
        if(!memailId){
            errors.memailId='Email is required';
        }
        else if (!/\S+@\S+\.\S+/.test(memailId)) {
            errors.memailId = 'Email is invalid';
       }
       if(! leaveReason){
        errors.leaveReason='Reason is required';
    }
        setErrors(errors);
        setIsFormValid(Object.keys(errors).length===0);
    };
    if(isExpired(localStorage.getItem('jwtToken'))){
        alert("Session Timeout Please Login again");
        window.location.href("/");
      }

    const { emailId, memailId, fromDate, toDate, leaveReason } = leave
    const onInputChange = (e) => {
        setLeave({
            ...leave,
            [e.target.name]: e.target.value
        });
    }
    const handleSubmit = async (e) => {
        e.preventDefault();
        if(isFormValid){
            console.log('submitting form',{emailId, memailId, fromDate, toDate, leaveReason});
        }
        await axios.post(`http://localhost:9002/leave`, {

            "emailId": emailId,
            "memailId": memailId,
            "fromDate": fromDate,
            "toDate": toDate,
            "leaveReason": leaveReason,
        }
        )
            .then(res => {
                console.log(res.data)
                if (res.status === 500) {
                    alert(res.data)
                }
                window.location.href = "/dispalyleave";
            })
            .catch(error => {
                console.error(error);
                if(error.response && error.response.status===500){
                    alert("Incorrect data");
                }
            });
        // navigate("/dispalyleave");

    };
    return (
        <div>
            <Employeedropdown></Employeedropdown>
            <div style={{marginTop:'4rem',marginBottom:'4rem'}}>
            <div className="container">
                <div className="row">
                    <div style={{backgroundColor:'#EDE7F6'}}className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
                        <h2 className="text-center m-4"> Apply leave</h2>
                        <form onSubmit={(e) => handleSubmit(e)}>
                            <div className="mb-3">
                                <label htmlFor="emailId" className="form-label">Employee EmailId</label>
                                <input
                                    type={"email"}
                                    className="form-control"
                                    placeholder="Enter your emailid"
                                    name="emailId"
                                    value={emailId}
                                    onChange={onInputChange}
                                    autoComplete="off"
                                ></input>
                                {errors.emailId && <div style={{color:'red'}}>{errors.emailId}
                            </div>}
                            </div>
                            <div className="mb-3">
                                <label htmlFor="memailId" className="form-label">Manager EmailId</label>
                                <input
                                    type={"email"}
                                    className="form-control"
                                    placeholder="Enter your emailid"
                                    name="memailId"
                                    value={memailId}
                                    onChange={onInputChange}
                                    autoComplete="off"
                                ></input>
                                {errors.memailId && <div style={{color:'red'}}>{errors.memailId}
                            </div>}
                            </div>
                            <div className="mb-3">
                                <label htmlFor="leaveReason" className="form-label">leaveReason</label>
                                <input
                                    type={"text"}
                                    className="form-control"
                                    placeholder="Enter your Reason"
                                    name="leaveReason"
                                    value={leaveReason}
                                    onChange={onInputChange}
                                    autoComplete="off"
                                ></input>
                                {errors.leaveReason&& <div style={{color:'red'}}>{errors.leaveReason}
                            </div>}
                            </div>


                            <div className='row'>
                                <div className='col-md-5'>
                                    <div className=" mb-1" style={{display:'inline-block',width:'100%'}}>
                                    <label htmlFor="fromDate" className="form-label">Leave From</label>
                                <input
                                    type={"Date"}
                                    className="form-control"
                                    placeholder="Enter your Date"
                                    name="fromDate"
                                    value={fromDate}
                                    onChange={onInputChange}
                                    style={{display:'inline-block', width: '230px', height: '2px', marginLeft: '5px', textalign: 'center', padding: '18px', fontSize: '14px' }}

                                ></input>
                                {errors.fromDate && <div style={{color:'red'}}>{errors.fromDate}
                            </div>}

                                    </div>

                                </div>
                                <div className='col-md-5'>
                                    <div className="mb-1">
                                    <label htmlFor="toDate" className="form-label">Leave To </label>
                                <input
                                    type={"Date"}
                                    className="form-control"
                                    placeholder="Enter your Date"
                                    name="toDate"
                                    value={toDate}
                                    onChange={onInputChange}
                                    
                                    style={{ width: '230px', height: '2px', marginLeft: '50px', padding: '18px', fontSize: '14px' }}
                                ></input>
                                {errors.toDate && <div style={{color:'red'}}>{errors.toDate}
                            </div>}

                                    </div>

                                </div>
                            </div>
                            <br></br>
                           
                            <button type="submit"onClick={validateForm}  className="btn btn-outline-success">Submit</button>
                            {/* <Link to="/"type="submit" className="btn btn-success">Submit</Link> */}
                            
                        </form>
                    </div>

                </div>
            </div>
        </div>
        </div>
    );
}

export default Applyleave;