export interface BlockContextMenuPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
