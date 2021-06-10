import React, { useState, useEffect, useRef } from 'react';


const Dropdown = ({ className, onUpdateDefault, optionList }) => {
    const [isOpen, setIsOpen] = useState(false);
    const [defaultText, SetDefaultText] = useState(null);
    const ref = useRef();
    const refFocus = useRef(null);
    useEffect(() => {
        console.log('Inside useEffect')
        
        const onBodyClicked = (event) => {
            if (ref.current && ref.current.contains(event.target)) {
                return;
            }
            setIsOpen(false)
        }
        document.body.addEventListener('click', onBodyClicked, { capture: true });
        return () => {
            document.body.removeEventListener('click', onBodyClicked, { capture: true })
        }
    }, []);
    let initialDefaultText;
    const options = optionList.map((option) => {
        let classList = "options";
        if(option.props.selected){
            initialDefaultText = option.props.children;
            classList = "options is-active";
        }
        return <div  className={classList} ref={refFocus} key={option.props.key} value={option.props.value} selected={option.props.selected} onClick={(option) => optionClick(option)} onMouseOver={(e)=> { toggleClass(e)}}>{option.props.children}</div>
    });

    const optionClick = (option) => {
        onUpdateDefault(option);
        SetDefaultText(option.target.innerText);
        setIsOpen(false);
    }
    
    const onDropdownClick = (e)=>{
        setIsOpen(!isOpen);
        
        for(let option of e.target.parentElement.children[1].children){
            
            if(option.innerText === e.target.innerText){
                console.log(option);
                option.classList.add('is-active');
            }else{
                option.classList.remove('is-active');
            }
        }
        
    }
    const toggleClass = (e)=>{
        for(let option of e.target.parentElement.children){
            
                option.classList.remove('is-active');
        }
    }
    return (
        <div ref={ref} className={`${className} dropdown-multiline ${isOpen ? "isopen" : ""}`} onClick={(e) => { onDropdownClick(e); }}>
            <span className="default-text">{defaultText ?  defaultText : initialDefaultText}</span>
            <div className="option-list">{options}</div>
        </div>

    );

}

export default Dropdown