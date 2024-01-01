import { createSlice } from '@reduxjs/toolkit'

const initialState = {
  contentDialogProps: {
    isModalOpen: false,
    title: '',
    handleClick: () => {},
    handleCancel: () => {},
    children: null
  }
}

export const modalState = createSlice({
  name: 'modalState',
  initialState,
  reducers: {
    setContentDialogProps: (state, { payload }) => {
      state.contentDialogProps = payload
    },
    resetModalState: () => {
      console.log('reset')
      return initialState
    }
  }
})

export const { setContentDialogProps, resetModalState } = modalState.actions

export default modalState.reducer
