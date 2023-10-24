import { createContext, useState } from "react";

export const AuthContext = createContext();

export function AuthContextProvider({ children }) {
const [token, setToken] = useState(null);

const logaUsuario = async () => {
    try {
    const token = 'meutoken';
    setToken(token);
    localStorage.setItem('dhodonto-token', token);
    } catch (error) {
    alert('deu error')
    }
}

const deslogaUsuario = () => {
    setToken(null);
    localStorage.removeItem('dhodonto-token');
}

return (
    <AuthContext.Provider value={{ token, logaUsuario, deslogaUsuario }}>
    {children}
    </AuthContext.Provider>
)
}