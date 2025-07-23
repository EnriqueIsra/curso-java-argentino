import axios from "axios"

const baseUrl = 'http://localhost:8080'

export const findAll = async () => {
    try{
        const response = await axios.get(baseUrl)
        return response
    } catch (error) {
        console.log(error)
    }
    return null;

}
export const create = async ({name, description, price}) => {
    
}
export const update = async ({id, name, description, price}) => {
    
}
export const remove = async (id) => {
    
}