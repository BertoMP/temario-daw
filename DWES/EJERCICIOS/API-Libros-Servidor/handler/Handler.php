<?php

class Handler
{
    private string $strTable;
    private array $arrParams;

    public function __construct()
    {
        $this->strTable = '';
        $this->arrParams = [];
        $this->fillAttributes();
    }

    private function fillAttributes(): void
    {
        $strURI = 'http://' . $_SERVER['SERVER_NAME'] . $_SERVER['REQUEST_URI'];

        $arrParseURL = parse_url($strURI);

        if (is_array($arrParseURL) && str_contains($strURI, 'index.php')) {
            $arrStrUri = explode('index.php', $strURI);

            $arrAttributes = explode('/', $arrStrUri[1]);

            $this->strTable = $arrAttributes[1] ?? '';
            $this->arrParams = array_slice($arrAttributes, 2);
        }
    }

    public function getTable(): string
    {
        return $this->strTable;
    }

    public function getParams(): array
    {
        return $this->arrParams;
    }
}