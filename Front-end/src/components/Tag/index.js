import Chip from '@mui/material/Chip';

export function StatusTag({ status }) {
  let color = () => {
    return status === 'draft'
      ? 'default'
      : status === 'sent'
      ? 'primary'
      : status === 'accepted'
      ? 'success'
      : status === 'expired'
      ? 'info'
      : 'error';
  };

  return <Chip color={color()}>{status}</Chip>;
}
