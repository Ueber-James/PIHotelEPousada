import { render } from "@testing-library/react"
import { BrowserRouter, MemoryRouter, Routes, Route } from "react-router-dom"
import { ContextProvider } from "../Components/utils/global.context"
import { useNavigate } from "react-router-dom"

const renderWithContext = (ui, providerValue)=>{
    return render(
        <BrowserRouter>
            <ContextProvider value={providerValue || {theme: "light", data: []}} >   
                {ui}
            </ContextProvider>
        </BrowserRouter>
    )
}

//Only for testing individual routes as /dentist/:id
export const renderWithRouter = (ui, {route = '/', path='/'}) => {
   useNavigate({}, 'Test page', route)

    return render(
        <MemoryRouter initialEntries={[route]}>
            <Routes>
                <Route index path={path} element={ui}/>
            </Routes>
        </MemoryRouter>
    )
}

export * from "@testing-library/react"
export {renderWithContext as render}  