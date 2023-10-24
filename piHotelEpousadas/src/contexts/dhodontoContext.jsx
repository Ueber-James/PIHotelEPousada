import { createContext, useEffect, useReducer } from 'react';
import { perfilReducer } from '../reducers/perfilReducer';

export const GithubContext = createContext();

export function dhOdontoContextProvider({ children }) {
const [listaDePerfis, dispatch] = useReducer(perfilReducer, [], () => {
    const perfisLocais = localStorage.getItem('dhodonto-perfis');
    return perfisLocais ? JSON.parse(perfisLocais) : [];
});

useEffect(() => {
    localStorage.setItem('dhodonto-perfis', JSON.stringify(listaDePerfis));
}, [listaDePerfis]);

const buscaPerfilPeloLogin = (perfisAntigos, perfilLogin) => {
    const perfil = perfisAntigos.find((perfilAntigo) => perfilAntigo.login === perfilLogin);
    return perfil;
}

const addUsuarioALista = (perfil) => dispatch({ type: 'ADICIONA_PERFIL', payload: perfil });

return (
    <dhodontoContext.Provider value={{ listaDePerfis, addUsuarioALista, buscaPerfilPeloLogin }}>
    {children}
    </dhodontoContext.Provider>
)
}