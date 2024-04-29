import { registerPlugin } from '@capacitor/core';

import type { BlockContextMenuPlugin } from './definitions';

const BlockContextMenu = registerPlugin<BlockContextMenuPlugin>(
  'BlockContextMenu',
  {
    web: () => import('./web').then(m => new m.BlockContextMenuWeb()),
  },
);

export * from './definitions';
export { BlockContextMenu };
