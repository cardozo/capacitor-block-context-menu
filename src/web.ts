import { WebPlugin } from '@capacitor/core';

import type { BlockContextMenuPlugin } from './definitions';

export class BlockContextMenuWeb
  extends WebPlugin
  implements BlockContextMenuPlugin
{
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
