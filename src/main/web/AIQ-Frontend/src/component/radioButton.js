import React, { useState, useEffect, useRef } from 'react';



const RadioButtons = ({ className, onUpdateDefault, optionList, name }) => {
    
    
   const checkedStatus=[];
    optionList.map((option) => {
        checkedStatus.push(option.props.selected);
    });
    const [isSelected, setIsSelected] = useState(checkedStatus);
    let options = [];
    for(let index= 0; index < optionList.length ; index++){
        let option = optionList[index];
        let selected = isSelected[index];
        options.push(
        selected ? 
        <div className="radio-buttonn-checkbox is-active" onClick={(e)=>{onParentClick(e)}}><div className="circle" /> <input id={option.props.value} type="radio" key={option.props.key} value={option.props.value} name={name} checked onChange={(e)=>{onClickHandler(e)}}/><label for = {option.props.value} >{option.props.children}</label></div>
        : <div className="radio-buttonn-checkbox" onClick={(e)=>{onParentClick(e)}}><div className="circle" /> <input id={option.props.value} type="radio" key={option.props.key} value={option.props.value} name={name} onChange={(e)=>{onClickHandler(e)}}/><label for = {option.props.value} >{option.props.children}</label></div>);
  
    }
    const onClickHandler = (e)=>{
        onUpdateDefault(e)
        const isChecked=[];
        for(let option of optionList){
            if(e.target.value == option.props.value){
                isChecked.push(true);
            }else{
                isChecked.push(false);
            }
        }
        setIsSelected(isChecked);
    }
    const onParentClick = e =>{
        if(e.target.classList.contains('circle')){
            e.target.nextElementSibling.click();
        }
    }   

return(
    <form className={`${className} radio-buttonn-form`}>
        {options}
    </form>
);

}

export default RadioButtons